package com.joker.demo.netty.bio.client;

import org.apache.commons.lang.CharSet;

import java.io.IOException;
import java.net.Socket;
import java.nio.charset.Charset;

/**
 * <p>
 * BIO 客户端
 * </p>
 *
 * @author jokerzzccc
 * @since 2023/8/31
 */
public class BioClient {

    public static void main(String[] args) {
        Socket socket = null;
        try {
            socket = new Socket("192.168.110.177", 7397);
            System.out.println("joker-demo-netty client start done. ");
            BioClientHandler bioClientHandler = new BioClientHandler(socket, Charset.forName("UTF-8"));
            bioClientHandler.start();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
