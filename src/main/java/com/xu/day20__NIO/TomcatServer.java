package com.xu.day20__NIO;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.LinkedList;
import java.util.List;

public class TomcatServer {

    static ByteBuffer byteBuffer = ByteBuffer.allocate(512);
    public static List<SocketChannel> channelList = new LinkedList<>();

    public static void main(String[] args) {
        try {
            ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
            SocketAddress socketAddress = new InetSocketAddress("127.0.0.1", 9098);
            serverSocketChannel.bind(socketAddress);
            serverSocketChannel.configureBlocking(false);

            while (true) {
                for(SocketChannel socketChannel : channelList) {
                    int read = socketChannel.read(byteBuffer);
                    //print accept message
                    if(read>0){
                        System.out.println("read = " + read);
                        byteBuffer.flip();
                        byte[] bs = new byte[read];
                        byteBuffer.get(bs);
                        System.out.println(new String(bs));
                        byteBuffer.flip();
                    } else if(read == -1) {
                        channelList.remove(socketChannel);
                    }
                }
                SocketChannel accept = serverSocketChannel.accept();
                if(accept!=null) {
                    System.out.println("conn success");
                    accept.configureBlocking(false);
                    channelList.add(accept);
                    System.out.println("channelList.size() = " + channelList.size());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
