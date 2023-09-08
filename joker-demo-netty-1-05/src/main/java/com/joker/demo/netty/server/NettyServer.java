package com.joker.demo.netty.server;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;

/**
 * <p>
 * 一个简单的Netty服务端示例
 * </p>
 *
 * @author jokerzzccc
 * @since 2023/8/31
 */
public class NettyServer {

    public static void main(String[] args) {
        new NettyServer().bind(7397);
    }

    private void bind(int port) {
        // 配置服务端 NIO 线程组
        EventLoopGroup parentGroup = new NioEventLoopGroup();
        EventLoopGroup childGroup = new NioEventLoopGroup();
        try {
            ServerBootstrap serverBootstrap = new ServerBootstrap();
            serverBootstrap.group(parentGroup, childGroup)
                    .channel(NioServerSocketChannel.class) // 异步非阻塞 TCP Socket 服务端监听通道
                    .option(ChannelOption.SO_BACKLOG, 128)
                    .childHandler(new MyChannelInitializer());
            ChannelFuture channelFuture = serverBootstrap.bind(port).sync();
            System.out.println("joker-demo-netty server start done. ");
            channelFuture.channel().closeFuture().sync();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            childGroup.shutdownGracefully();
            parentGroup.shutdownGracefully();
        }

    }

}
