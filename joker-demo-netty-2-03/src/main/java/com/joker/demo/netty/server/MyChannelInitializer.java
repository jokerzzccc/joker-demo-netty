package com.joker.demo.netty.server;

import com.joker.demo.netty.codec.ObjDecoder;
import com.joker.demo.netty.codec.ObjEncoder;
import com.joker.demo.netty.domain.MsgInfo;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.socket.SocketChannel;

/**
 * <p>
 *
 * </p>
 *
 * @author jokerzzccc
 * @since 2023/9/10
 */
public class MyChannelInitializer extends ChannelInitializer<SocketChannel> {

    @Override
    protected void initChannel(SocketChannel channel) {
        //对象传输处理
        channel.pipeline().addLast(new ObjDecoder(MsgInfo.class));
        channel.pipeline().addLast(new ObjEncoder(MsgInfo.class));
        // 在管道中添加我们自己的接收数据实现方法
        channel.pipeline().addLast(new MyServerHandler());
    }

}