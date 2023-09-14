package com.joker.demo.test;

import com.joker.demo.netty.server.NettyServer;

/**
 * <p>
 *
 * </p>
 *
 * @author jokerzzccc
 * @since 2023/9/13
 */
public class NettyServerTest {

    public static void main(String[] args) {
        // 启动服务
        new NettyServer().bing(7397);
    }

}
