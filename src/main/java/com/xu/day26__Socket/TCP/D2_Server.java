package com.xu.day26__Socket.TCP;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 多线程的服务器
 *     建议BufferedReader和PrintStream配合使用
 * @see PrintStream
 */
public class D2_Server {

    public static void main(String[] args) throws IOException {
        ServerSocket ss = new ServerSocket(12345);

        while (true) {
            Socket socket = ss.accept();
            new Thread() {
                @Override
                public void run() {

                    try {
                        //创建输入输出流，并装饰为高级流
                        InputStream is = socket.getInputStream();
                        OutputStream os = socket.getOutputStream();

                        BufferedReader br = new BufferedReader(new InputStreamReader(is));
                        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(os));
                        //\r\n 和 flush 都不可少
                        bw.write("我是服务端\r\n");
                        bw.flush();
                        System.out.println(br.readLine());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }.start();
        }
    }
}
