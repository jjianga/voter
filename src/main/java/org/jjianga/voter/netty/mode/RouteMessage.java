package org.jjianga.voter.netty.mode;

import io.netty.channel.Channel;
import io.netty.handler.timeout.IdleStateEvent;

import java.util.Map;

/**
 * @author jjianga
 */
public interface RouteMessage {
    /**
     *  socket 连接成功
     * @param channel 连接通道
     * @param url   连接时带的url
     * @param param 连接时的参数
     * @return 是否允许连通
     */
    boolean online(Channel channel, String url, Map<String, String> param);

    /**
     *  socket 离线
     * @param channel 断开的通道
     */
    void offline(Channel channel);

    /**
     *  socket 心跳停止
     * @param channel   通道
     * @param idleStateEvent 事件
     */
    void heartbeatStop(Channel channel, IdleStateEvent idleStateEvent);

    /**
     *  接收到消息
     * @param channel  //有消息的通道
     * @param message 接收到的消息
     */
    void acceptorMessage(Channel channel, String message);
}
