package org.jjianga.voter.netty;

import java.util.concurrent.TimeUnit;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Service;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.HttpServerCodec;
import io.netty.handler.codec.http.websocketx.WebSocketServerProtocolHandler;
import io.netty.handler.stream.ChunkedWriteHandler;
import io.netty.handler.timeout.IdleStateHandler;

/**
 * websocket 启动类
 */
@Service
public class SocketStart implements ApplicationContextAware{
	private static Logger logger = LoggerFactory.getLogger(SocketStart.class);
	private ApplicationContext applicationContext;
    @Value("${netty.server.websocket.port}")
    int port;
	@Value("${netty.server.websocket.websocketPath}")
	String websocketPath;
	NettyServer nettyServer = new NettyServer();

	@PostConstruct
	public void startSocket() {
		nettyServer.init(port, new ChannelInitializer<SocketChannel>() { // 绑定客户端连接时候触发操作
			@Override
			protected void initChannel(SocketChannel ch) throws Exception {
//                ch.pipeline().addLast(new LoggingHandler(LogLevel.INFO));    // 开启日志，可以设置日志等级
				logger.info("收到新连接,连接用户{},", ch.remoteAddress());
				// websocket协议本身是基于http协议的，所以这边也要使用http解编码器
				ch.pipeline().addLast(new HttpServerCodec());
				// 以块的方式来写的处理器
				ch.pipeline().addLast(new ChunkedWriteHandler());
				ch.pipeline().addLast(new HttpObjectAggregator(8192));
				ch.pipeline().addLast(new IdleStateHandler(30,30,30, TimeUnit.MINUTES));
				ch.pipeline().addLast(applicationContext.getBean(WebSocketHandler.class));
				ch.pipeline().addLast(
						new WebSocketServerProtocolHandler(websocketPath,
								null, true, 65536 * 10));
			}
		});
	}

	@PreDestroy
	public void close(){
		nettyServer.close();
	}

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.applicationContext = applicationContext;
	}
}
