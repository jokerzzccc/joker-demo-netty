package com.joker.demo.netty.server;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioDatagramChannel;

/**
 * <p>
 * channel 初始化
 * </p>
 *
 * @author jokerzzccc
 * @since 2023/9/1
 */
public class MyChannelInitializer extends ChannelInitializer<NioDatagramChannel> {

    private EventLoopGroup group = new NioEventLoopGroup();

    @Override
    protected void initChannel(NioDatagramChannel ch) throws Exception {
        ChannelPipeline pipeline = ch.pipeline();
        // 解码转String，注意调整自己的编码格式GBK、UTF-8
        //pipeline.addLast("stringDecoder", new StringDecoder(Charset.forName("GBK")));
        pipeline.addLast(group, new MyServerHandler());
    }

}
