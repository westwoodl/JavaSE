package com.xu.day26__Socket;

/**
 * 1.应用层 网络服务与最终用户的一个接口。协议有：HTTP FTP TFTP SMTP SNMP DNS TELNET HTTPS POP3 DHCP
 * 2.表示层 数据的表示、安全、压缩。（在五层模型里面已经合并到了应用层）格式有，JPEG、ASCll、DECOIC、加密格式等
 * 3.会话层 建立、管理、终止会话。（在五层模型里面已经合并到了应用层）对应主机进程，指本地主机与远程主机正在进行的会话
 * 4.传输层 定义传输数据的协议端口号，以及流控和差错校验。 协议有：TCP UDP，数据包一旦离开网卡即进入网络传输层
 * 5.网络层 进行逻辑地址寻址，实现不同网络之间的路径选择。协议有：ICMP IGMP IP（IPV4 IPV6） ARP RARP
 * 6.数据链路层 建立逻辑连接、进行硬件地址寻址、差错校验 [2]  等功能。（由底层网络定义协议）将比特组合成字节进而组合成帧，用MAC地址访问介质，错误发现但不能纠正。
 * 7.物理层 建立、维护、断开物理连接。（由底层网络定义协议）
 */

/**
 * TCP/IP四层模型介绍
 * 1.应用层：负责处理特定的应用程序细节。
 * 2.传输层：主要为两台主机上的应用提供端到端的通信。
 * 3.网络层（互联网层）：处理分组在网络中的活动，比如分组的选路。
 * 4.链路层（数据链路层/网络接口层）：包括操作系统中的设备驱动程序、计算机中对应的网络接口卡
 */

import java.io.IOException;
import java.net.*;
import java.util.Scanner;

/**
 * https://baike.baidu.com/item/socket
 * 网络上的两个程序通过一个双向的通信连接实现数据的交换，这个连接的一端称为一个socket。
 * 建立网络通信连接至少要一对端口号(socket)。socket本质是编程接口(API)，对TCP/IP的封装，
 * TCP/IP也要提供可供程序员做网络开发所用的接口，这就是Socket编程接口；
 *
 * 1.网络上具有唯一ip：port组合在一起，组成唯一标识的socket
 * 2.通信的两端都有socket
 * 3.网络通信其实就是socket的通信
 * 4.两个socket通过io流传输
 *
 * @see java.net.Socket
 */
public class Demo1_SocketSend {

    /**
     * 1.发送send
     *
     * @param args
     * @throws SocketException
     * @throws UnknownHostException
     */
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
                new SendAndReceive().send(6666);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static class ReceiveThread extends Thread {
        @Override
        public void run() {
            try {
                new SendAndReceive().receive(7777);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
