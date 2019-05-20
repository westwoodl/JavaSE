package com.xu.day26__Socket.TCP;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 上传文件到服务端
 */
public class T1_Server {

    public static void main(String[] args) throws IOException {
        ServerSocket ss = new ServerSocket(12345);

        while (true) {
            Socket socket = ss.accept();
            new Thread() {
                @Override
                public void run() {
                    try (
                            InputStream is = socket.getInputStream();//接受客户端数据
                            OutputStream os = socket.getOutputStream();//发送响应

                            BufferedReader br = new BufferedReader(new InputStreamReader(is));
                    ) {
                        int len;
                        byte[] arr = new byte[8192];
                        String name = br.readLine();
                        System.out.println(name);
                        os.write(name.getBytes());//停顿一下，让后面的传输完整

                        //开始接受文件并写入本地
                        FileOutputStream fos = new FileOutputStream(name+".jpg");
                        while ((len=is.read(arr))!=-1){
                            fos.write(arr, 0, len);
                            System.out.println(len);
                        }
                        fos.close();

                        System.out.println("---传书完成---");
                        os.write(new byte[]{-2}, 0, 1);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }.start();
        }
    }
}
