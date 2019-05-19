package com.xu.day26__Socket.TCP;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class D2_Server {

    public static void main(String[] args) throws IOException {
        ServerSocket ss = new ServerSocket(12345);

        Socket socket = ss.accept();
        InputStream is = socket.getInputStream();
        OutputStream os = socket.getOutputStream();

        BufferedReader br = new BufferedReader(new InputStreamReader(is));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(os));

        bw.write("我是服务端\r\n");
        bw.flush();
        System.out.println(br.readLine());
    }
}
