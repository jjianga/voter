package org.jjianga.voter.netty;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.mysql.cj.util.StringUtils;
import io.netty.buffer.ByteBuf;
import io.netty.handler.codec.http.websocketx.BinaryWebSocketFrame;
import org.jjianga.voter.netty.mode.RouteMessage;
import org.jjianga.voter.util.StringToHex;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.codec.http.FullHttpRequest;
import io.netty.handler.timeout.IdleStateEvent;

@Scope("prototype")
@Service
public class WebSocketHandler extends SimpleChannelInboundHandler<BinaryWebSocketFrame> {
	private static final Logger logger = LoggerFactory.getLogger(WebSocketHandler.class);

	@Value("${netty.server.websocket.websocketPath}")
	String websocketPath;

	private static final ExecutorService executor = Executors.newFixedThreadPool(6);

	private List<RouteMessage> routeMessageList;

	@Autowired
	public void setWebSocketHandler(List<RouteMessage> routeMessageList) {
		this.routeMessageList = routeMessageList;
	}

	@Override
	public void channelActive(ChannelHandlerContext ctx){
		logger.debug("{}与客户端建立连接，通道开启！", ctx.channel().remoteAddress());
		ctx.fireChannelActive();
	}

	@Override
	public void channelInactive(ChannelHandlerContext ctx){
		logger.debug("{}与客户端断开连接，通道关闭！", ctx.channel().remoteAddress());
		// TODO	用户离线
		for (RouteMessage routeMessage : routeMessageList) {
			routeMessage.offline(ctx.channel());
		}
		ctx.fireChannelInactive();
	}

	@Override
	public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
		// 首次连接是FullHttpRequest
		if (msg instanceof FullHttpRequest) {
			FullHttpRequest request = (FullHttpRequest) msg;
			String uri = request.uri();
			String newUrl = null;
			Map<String, String> paramMap = getUrlParams(uri);
			// 如果url包含参数，需要处理
			if (uri.contains("?")) {
				newUrl = uri.substring(0, uri.indexOf("?"));
				request.setUri(newUrl);
				logger.info("请求路径：{}",newUrl);
			}
			logger.debug("接收到的参数是：{}", JSON.toJSONString(paramMap));
			String openId = paramMap.get("openId");
			if(openId != null || true) {
				request.setUri(websocketPath);
			}else {
				logger.error("NO OPENID!");
			}
			for (RouteMessage routeMessage : routeMessageList) {
				routeMessage.online(ctx.channel(), newUrl, paramMap);
			}
		}
		super.channelRead(ctx, msg);
	}

	@Override
	protected void channelRead0(ChannelHandlerContext channelHandlerContext, BinaryWebSocketFrame binaryWebSocketFrame) {
		ByteBuf content = binaryWebSocketFrame.content();
		final int length = content.readableBytes();
		final byte[] array = new byte[length];
		content.getBytes(content.readerIndex(), array, 0, length);
		logger.info("├ [二进制数据]:{}", array);
		String message = StringToHex.bytesToHexString(array);
		executor.execute(new Runnable() {
			@Override
			public void run() {
				logger.info("转16字符串:{}", message);
				for (RouteMessage routeMessage : routeMessageList) {
					routeMessage.acceptorMessage(channelHandlerContext.channel(), message);
				}
			}
		});
	}
	
	@Override
    public void userEventTriggered(ChannelHandlerContext ctx, Object evt) throws Exception {
		if(!IdleStateEvent.class.equals(evt.getClass()))return;
        IdleStateEvent event = (IdleStateEvent)evt;
//        String eventType = null;
        switch (event.state()){
            case READER_IDLE: //读空闲
				for (RouteMessage routeMessage : routeMessageList) {
					routeMessage.heartbeatStop(ctx.channel(),event);
				}
//                logger.warn("半小时没有写入数据给服务器，断开连接！");
                break;
            case WRITER_IDLE:
//                eventType = //写空闲
                // 不处理
                break;
            case ALL_IDLE: //读写空闲
                // 不处理
                break;
        }
    }
	/**
	 *  解析url参数
	 * @param url 要解析的参数列表 ?a=1&b=2
	 * @return 参数Map
	 */
	private static Map<String, String> getUrlParams(String url) {
		Map<String, String> map = new HashMap<>();
		url = url.replace("?", ";");
		if (!url.contains(";")) {
			return map;
		}
		if (url.split(";").length > 0) {
			String[] arr = url.split(";")[1].split("&");
			for (String s : arr) {
				String key = s.split("=")[0];
				String value = s.split("=")[1];
				map.put(key, value);
			}
			return map;
		} else {
			return map;
		}
	}

}
