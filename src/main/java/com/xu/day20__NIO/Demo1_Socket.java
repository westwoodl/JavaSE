package com.xu.day20__NIO;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;

/**
 * io的缺点：对每一个连接都开启线程，浪费资源，
 */
public class Demo1_Socket {

    public static void main(String[] args) throws IOException {


        Socket socket = new Socket();
        socket.bind(new InetSocketAddress("127.0.0.1", 9865));

        socket.connect(new InetSocketAddress("127.0.0.1", 9098));

        OutputStream outputStream = socket.getOutputStream();

        outputStream.write("caonima".getBytes());

        outputStream.close();
        socket.close();
    }
}
