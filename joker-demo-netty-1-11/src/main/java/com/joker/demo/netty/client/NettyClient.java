package com.joker.demo.netty.client;

import io.netty.bootstrap.Bootstrap;
import io.netty.buffer.Unpooled;
import io.netty.channel.Channel;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.DatagramPacket;
import io.netty.channel.socket.nio.NioDatagramChannel;

import java.net.InetSocketAddress;
import java.nio.charset.Charset;

/**
 * <p>
 *
 * </p>
 *
 * @author jokerzzccc
 * @since 2023/9/9
 */
public class NettyClient {

    public static void main(String[] args) {
        EventLoopGroup workerGroup = new NioEventLoopGroup();
        try {
            Bootstrap bootstrap = new Bootstrap();
            bootstrap.group(workerGroup)
                    .channel(NioDatagramChannel.class)
                    .handler(new MyChannelInitializer());
            Channel channel = bootstrap.bind(7398).sync().channel();
            channel.writeAndFlush(new DatagramPacket(
                            Unpooled.copiedBuffer("你好端口7397的服务端，我是客户端小爱，你在吗！", Charset.forName("GBK")),
                            new InetSocketAddress("192.168.31.107", 7397)))
                    .sync();
            channel.closeFuture().await();

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            workerGroup.shutdownGracefully();
        }
    }

}
