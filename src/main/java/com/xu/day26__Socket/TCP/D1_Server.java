package com.xu.day26__Socket.TCP;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class D1_Server {

    public static void main(String[] args) throws IOException {
        ServerSocket ss = new ServerSocket(12345);

        while (true) {
            Socket socket = ss.accept();
            InputStream is = socket.getInputStream();
            OutputStream os = socket.getOutputStream();

            os.write("Fuck You Asshole".getBytes());
            byte[] arr = new byte[1024];
            int len = is.read(arr);

            System.out.println(new String(arr, 0, len));
        }
    }
}
