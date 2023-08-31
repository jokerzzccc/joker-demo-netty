package com.joker.demo.netty.aio.server;

import com.joker.demo.netty.aio.ChannelInitializer;

import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.charset.Charset;
import java.util.concurrent.TimeUnit;

/**
 * <p>
 * 初始化
 * </p>
 *
 * @author jokerzzccc
 * @since 2023/8/31
 */
public class AioServerChannelInitializer extends ChannelInitializer {

    @Override
    protected void initChannel(AsynchronousSocketChannel channel) throws Exception {
        channel.read(ByteBuffer.allocate(1024), 10, TimeUnit.SECONDS, null
                , new AioServerHandler(channel, Charset.forName("GBK")));
    }

}
