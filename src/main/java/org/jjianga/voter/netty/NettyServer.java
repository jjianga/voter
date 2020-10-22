package org.jjianga.voter.netty;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;

/**
 * 
 * @author jjianga
 *
 */
public class NettyServer {
	private Logger logger = LoggerFactory.getLogger(NettyServer.class);
	private ServerBootstrap serverBootstrap = new ServerBootstrap();
	private EventLoopGroup bossGroup = new NioEventLoopGroup();
	private EventLoopGroup group = new NioEventLoopGroup();
	/**
	 * 	初始化，并且监听端口
	 * @param port
	 * @param channelInitializer
	 */
	public void init(int port, ChannelInitializer<SocketChannel> channelInitializer) {
		// 需要开启一个新的线程来执行netty server 服务器
		new Thread(new Runnable() {
			public void run() {
				try {
					startServer( port, channelInitializer);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}).start();
	}
	/**
	 * 	关闭  WebSoket 服务器方法
	 */
	public void close() {
		logger.info("关闭服务器....");
		bossGroup.shutdownGracefully();
		group.shutdownGracefully();
	}
	/**
	 * 	启动 WebSoket 监听
	 * @param port
	 * @param channelInitializer
	 * @throws Exception
	 */
	public void startServer(int port, ChannelInitializer<SocketChannel> channelInitializer) throws Exception {
		try {
			serverBootstrap.option(ChannelOption.SO_BACKLOG, 1024);
			serverBootstrap.group(group, bossGroup) 		// 绑定线程池
					.channel(NioServerSocketChannel.class) 	// 指定使用的channel
					.localAddress(port)				// 绑定监听端口
					.childHandler(channelInitializer);
			ChannelFuture cf = serverBootstrap.bind().sync(); // 服务器异步创建绑定
			logger.info("启动成功,正在监听：{},", cf.channel().localAddress());
			cf.channel().closeFuture().sync(); // 关闭服务器通道
		} finally {
			group.shutdownGracefully().sync(); // 释放线程池资源
			bossGroup.shutdownGracefully().sync();
		}
	}
}
