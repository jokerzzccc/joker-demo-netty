package com.joker.demo.netty.nio.server;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

/**
 * <p>
 * NIO Server
 * </p>
 *
 * @author jokerzzccc
 * @since 2023/8/31
 */
public class NioServer {

    private Selector selector;
    private ServerSocketChannel serverSocketChannel;

    public static void main(String[] args) {
        new NioServer().bind(7398);
    }

    public void bind(int port) {
        try {
            selector = Selector.open();
            serverSocketChannel = ServerSocketChannel.open();
            serverSocketChannel.configureBlocking(false);
            serverSocketChannel.socket().bind(new InetSocketAddress(port), 1024);
            serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
            System.out.println("joker-demo-netty server start done. ");
            new NioServerHandler(selector, Charset.forName("GBK")).start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
