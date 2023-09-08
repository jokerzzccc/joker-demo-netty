package com.joker.demo.netty.server;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

import java.nio.charset.Charset;
import java.util.Date;

/**
 * <p>
 *
 * </p>
 *
 * @author jokerzzccc
 * @since 2023/9/1
 */
public class MyServerHandler extends ChannelInboundHandlerAdapter {

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        // 接受 msg 消息
        ByteBuf buf = (ByteBuf) msg;
        byte[] msgByte = new byte[buf.readableBytes()];
        buf.readBytes(msgByte);
        System.out.print(new Date() + "接收到消息：");
        System.out.println(new String(msgByte, Charset.forName("GBK")));
    }

}
