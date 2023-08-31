package com.joker.demo.netty.aio.server;

import java.net.InetSocketAddress;
import java.nio.channels.AsynchronousChannelGroup;
import java.nio.channels.AsynchronousServerSocketChannel;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executors;

/**
 * <p>
 *
 * </p>
 *
 * @author jokerzzccc
 * @since 2023/8/31
 */
public class AioServer extends Thread {

    private AsynchronousServerSocketChannel serverSocketChannel;

    public static void main(String[] args) {
        new AioServer().start();
    }

    @Override
    public void run() {
        try {
            serverSocketChannel = AsynchronousServerSocketChannel.open(
                    AsynchronousChannelGroup.withCachedThreadPool(
                            Executors.newCachedThreadPool(), 10)
            );
            serverSocketChannel.bind(new InetSocketAddress(7399));
            System.out.println("joker-demo-netty server start done. ");
            // 等待
            CountDownLatch latch = new CountDownLatch(1);
            serverSocketChannel.accept(this, new AioServerChannelInitializer());
            latch.await();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public AsynchronousServerSocketChannel serverSocketChannel() {
        return serverSocketChannel;
    }

}
