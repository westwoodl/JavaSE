package com.xu.day26__Socket.TCP;


import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class D1_Client {

    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("127.0.0.1", 12345);

        InputStream is = socket.getInputStream();
        OutputStream os = socket.getOutputStream();

        byte[] arr = new byte[1024];
        int len = is.read(arr);

        System.out.println(new String(arr, 0, len));

        os.write("Fuck You Asshole".getBytes());

        socket.close();
    }
}
