package org.jjianga.voter.netty;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.Channel;
import io.netty.channel.group.ChannelGroup;
import io.netty.channel.group.DefaultChannelGroup;
import io.netty.handler.codec.http.websocketx.BinaryWebSocketFrame;
import io.netty.handler.timeout.IdleStateEvent;
import io.netty.util.concurrent.GlobalEventExecutor;
import org.jjianga.voter.entity.BestObject;
import org.jjianga.voter.entity.VoteInfo;
import org.jjianga.voter.netty.mode.RouteMessage;
import org.jjianga.voter.service.accept.AcceptMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

@Service
public class MessageDistribute implements RouteMessage {
    private final List<AcceptMessage> acceptMessages;
    @Autowired
    public MessageDistribute(List<AcceptMessage> acceptMessages) {
        this.acceptMessages = acceptMessages;
    }

    @Override
    public boolean online(Channel channel, String url, Map<String, String> param) {
        SocketGroup.channelGroup.add(channel);
        return true;
    }

    @Override
    public void offline(Channel channel) {

    }

    @Override
    public void heartbeatStop(Channel channel, IdleStateEvent idleStateEvent) {

    }

    @Override
    public void acceptorMessage(Channel channel, String message) {
        String reportType = message.substring(0, 4);
        for (AcceptMessage acceptMessage:acceptMessages){
            if(acceptMessage.isType(reportType)){
                //前置处理 接收消息
                BestObject bestObject = acceptMessage.getAcceptMessage(reportType, message);
                // 后置处理 把响应消息发送出去
                if(bestObject != null){
                    byte[] rest = acceptMessage.responseAcceptMessage(bestObject);
                    if(rest != null){
                        System.out.println(Arrays.toString(rest));
                        ByteBuf byteBuf = Unpooled.directBuffer().writeBytes(rest);
                        channel.writeAndFlush(new BinaryWebSocketFrame(byteBuf));
                    }
                }
            }
        }
    }
}
