package com.xu.day26__Socket;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.Scanner;

public class Demo2_SocketReceive {
    public static void main(String[] args) throws IOException {
        Thread send = new SendThread();
        Thread receive = new ReceiveThread();

        send.start();
        receive.start();
    }
    private static class SendThread extends Thread {
        @Override
        public void run() {
            try {
                new SendAndReceive().send(7777);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    private static class ReceiveThread extends Thread {
        @Override
        public void run() {
            try {
                new SendAndReceive().receive(6666);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}


class SendAndReceive {

    /**
     * @param target_port 发送的目标端口
     * @throws IOException
     */
    public void send(int target_port) throws IOException {
        try (DatagramSocket socket = new DatagramSocket();) { //创建码头
            Scanner s = new Scanner(System.in);
            while (true) {
                System.out.print("<<");
                String str = s.nextLine();
                if ("quit".equals(str))
                    break;
                DatagramPacket packet = new DatagramPacket(   //创建集装箱
                        str.getBytes(), str.getBytes().length, InetAddress.getByName("127.0.0.1"), target_port);
                socket.send(packet);
            }
            //socket.close();
        }
    }

    /**
     * @param port 本地接受的port
     * @throws IOException
     */
    public void receive(int port) throws IOException {
        try (DatagramSocket socket = new DatagramSocket(port);) {

            DatagramPacket packet = new DatagramPacket(new byte[1024], 1024);
            while (true) {
                socket.receive(packet); //接受数据
                System.out.print(
                        packet.getAddress()+":"+packet.getPort()+">>"+
                                new String(packet.getData(), 0, packet.getLength()));
            }
        }
    }
}