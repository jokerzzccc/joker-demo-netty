package com.joker.demo.netty.server;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.EmptyByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.channel.socket.DatagramPacket;
import io.netty.handler.codec.http.*;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
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

        if (msg instanceof HttpRequest) {
            DefaultHttpRequest request = (DefaultHttpRequest) msg;
            System.out.println("URI:" + request.getUri());
            System.err.println(msg);
        }

        if (msg instanceof HttpContent) {
            LastHttpContent httpContent = (LastHttpContent) msg;
            ByteBuf byteData = httpContent.content();
            if (!(byteData instanceof EmptyByteBuf)) {
                //接收msg消息
                byte[] msgByte = new byte[byteData.readableBytes()];
                byteData.readBytes(msgByte);
                System.out.println(new String(msgByte, Charset.forName("UTF-8")));
            }
        }

        String sendMsg = "微信公众号：bugstack虫洞栈，欢迎您的关注&获取源码！不平凡的岁月终究来自你每日不停歇的刻苦拼搏，每一次真正成长都因看清脚下路而抉择出的生活。愿你我；承遇朝霞，年少正恰，整装戎马，刻印风华。\n" +
                "博客栈：https://bugstack.cn\n" +
                "内容介绍：本公众号会每天定时推送科技资料；专题、源码、书籍、视频、咨询、面试、环境等方面内容。尤其在技术专题方面会提供更多的原创内容，让更多的程序员可以从最基础开始了解到技术全貌，目前已经对外提供的有；《手写RPC框架》、《用Java实现JVM》、《基于JavaAgent的全链路监控》、《Netty案例》等专题。\n" +
                "获取源码：\n" +
                "关注｛bugstack虫洞栈｝公众号获取源码，回复<用Java实现jvm源码>\n" +
                "关注｛bugstack虫洞栈｝公众号获取源码，回复<netty源码>\n" +
                "关注｛bugstack虫洞栈｝公众号获取源码，回复<rpc源码>\n" +
                "关注｛bugstack虫洞栈｝公众号获取源码，回复<基于JavaAgent的全链路监控>";

        FullHttpResponse response = new DefaultFullHttpResponse(
                HttpVersion.HTTP_1_1,
                HttpResponseStatus.OK,
                Unpooled.wrappedBuffer(sendMsg.getBytes(StandardCharsets.UTF_8)));
        response.headers()
                .set(HttpHeaderNames.CONTENT_TYPE, "text/plain;charset=UTF-8")
                .set(HttpHeaderNames.CONTENT_LENGTH, response.content().readableBytes())
                .set(HttpHeaderNames.CONNECTION, HttpHeaderValues.KEEP_ALIVE);

        ctx.writeAndFlush(response);
    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        ctx.flush();
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        ctx.close();
        cause.printStackTrace();
    }

}
