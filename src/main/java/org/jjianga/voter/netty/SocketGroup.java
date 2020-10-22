package org.jjianga.voter.netty;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.group.ChannelGroup;
import io.netty.channel.group.DefaultChannelGroup;
import io.netty.handler.codec.http.websocketx.BinaryWebSocketFrame;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;
import io.netty.util.concurrent.GlobalEventExecutor;
import org.jjianga.voter.service.send.SendMessage;

import java.util.Arrays;

public class SocketGroup {
    public static ChannelGroup channelGroup = new DefaultChannelGroup(GlobalEventExecutor.INSTANCE);

    public static void sendMessage(SendMessage sendMessage){
        System.out.println(Arrays.toString(sendMessage.toMessageByte()));
        ByteBuf byteBuf = Unpooled.directBuffer().writeBytes(sendMessage.toMessageByte());
        channelGroup.writeAndFlush(new BinaryWebSocketFrame(byteBuf));
    }
}
