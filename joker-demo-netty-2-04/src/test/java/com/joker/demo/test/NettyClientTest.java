package com.joker.demo.test;

import com.joker.demo.netty.client.NettyClient;
import com.joker.demo.netty.domain.FileTransferProtocol;
import com.joker.demo.netty.util.MsgUtil;
import io.netty.channel.ChannelFuture;

import java.io.File;

/**
 * <p>
 *
 * </p>
 *
 * @author jokerzzccc
 * @since 2023/9/13
 */
public class NettyClientTest {

    public static void main(String[] args) {
        // 启动客户端
        ChannelFuture channelFuture = new NettyClient().connect("127.0.0.1", 7397);

        // 文件信息{文件大于1024kb方便测试断点续传}
        File file = new File("F:\\03-code\\01_mySourceCode\\joker-demo-netty\\joker-demo-netty-2-04\\src\\test\\java\\com\\joker\\demo\\test\\测试传输文件.rar");
        FileTransferProtocol fileTransferProtocol = MsgUtil.buildRequestTransferFile(file.getAbsolutePath(), file.getName(), file.length());

        // 发送信息；请求传输文件
        channelFuture.channel().writeAndFlush(fileTransferProtocol);
    }

}
