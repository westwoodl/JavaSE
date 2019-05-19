package com.xu.day26__Socket.TCP;

import java.io.*;
import java.net.Socket;

/**
 * 注意事项：readLine()要求有换行标识，write()要输出换行标识，要调用flush()刷新缓冲区。
 * 注意readLine()方法，通过查看JDK中关于此方法的凝视可知，它是读取一行数据，
 * 这行数据的末尾必须有换行符标识符说明到此为止是一行。不然readLine()方法无法顺利读取。
 *
 * BufferedWriter是数据长度超过缓冲区才会刷新，而不是换行刷新（换行刷新请使用PrintStream）
 * @see PrintStream
 */
public class D2_Client {


    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("127.0.0.1", 12345);

        InputStream is = socket.getInputStream();
        OutputStream os = socket.getOutputStream();

        BufferedReader br = new BufferedReader(new InputStreamReader(is));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(os));


        System.out.println(br.readLine());

        bw.write("I am Client\r\n");
        bw.flush();//
        /*
         flush准确的说不是因为flush方法的问题，
         而是因为服务器端接受数据时使用的readLine()
         方法必须要接收到一个换行符才能读取一行，
         */



        socket.close();
    }
}
