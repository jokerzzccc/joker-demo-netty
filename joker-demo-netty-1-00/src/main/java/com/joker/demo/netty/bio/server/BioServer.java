package com.joker.demo.netty.bio.server;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.Charset;

/**
 * <p>
 *
 * </p>
 *
 * @author jokerzzccc
 * @since 2023/8/31
 */
public class BioServer extends Thread{

    private ServerSocket serverSocket;

    public static void main(String[] args) {
        BioServer bioServer = new BioServer();
        bioServer.start();
    }

    @Override
    public void run() {
        try {
            serverSocket = new ServerSocket();
            serverSocket.bind(new InetSocketAddress(7397));
            System.out.println("joker-demo-netty server start done. ");
            while (true){
                Socket socket = serverSocket.accept();
                BioServerHandler bioServerHandler = new BioServerHandler(socket, Charset.forName("GBK"));
                bioServerHandler.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        super.run();
    }

}
