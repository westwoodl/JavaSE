package com.xu.day26__Socket.TCP;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

/**
 * 将文件上传到服务端
 *     注意事项：需要关闭socket才能完成传输
 */
public class T1_Client {


    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        String filepath = "C:\\Users\\RongChao Xu\\Pictures\\lock\\1.jpg";
        File file = new File(filepath);
        while (true) {
            System.out.println("输入y开始传送" + filepath + ", 或输入文件路径上传：");
            String str = sc.nextLine();
            if (!"y".equalsIgnoreCase(str)) {
                File file2 = new File(str);
                if (file2.exists() && file2.isFile()) {
                    file = file2;
                    break;
                } else
                    System.out.println(str+"文件不存在！");
            } else
                break;
        }
        String name = file.getName();//文件名
        //开始传输文件
        try (
                Socket socket = new Socket("127.0.0.1", 12345);
                InputStream is = socket.getInputStream();//用于接受服务端响应
                OutputStream os = socket.getOutputStream();//向服务端发送数据
                FileInputStream fis = new FileInputStream(file);
                PrintStream ps = new PrintStream(os);//添加一个打印流，功能强大，能io字节和字符
        ) {
            int len;
            byte[] arr = new byte[8192];
            //传输文件名
            ps.println(name);

            //接受服务器响应，这里我们将文件名又传回来了
            len = is.read(arr);
            System.out.println(new String(arr, 0, len));

            //向服务端发送数据
            while ((len = fis.read(arr)) != -1) {
                os.write(arr, 0, len);
                System.out.println(len);
            }
            socket.shutdownOutput();//切断输出

            //接受服务端响应
            len = is.read(arr);
            System.out.println(new String(arr, 0, len));
            if(arr[0]==-2&&len==1)
                System.out.println("传输成功");
        }
    }
}
