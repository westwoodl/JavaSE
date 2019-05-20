package com.xu.day26__Socket.TCP;

import com.xu.day15__Collection.bean.S;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

/**
 * 不关流，传输文件会完成吗
 */
public class FileIOStream {

    @Test
    public void test() throws IOException {

        FileInputStream fis = new FileInputStream("C:\\Users\\RongChao Xu\\Pictures\\lock\\1.jpg");
        FileOutputStream fos = new FileOutputStream("1.jpg");

        int len;
        byte[] arr = new byte[8192];

        while ((len=fis.read(arr))!=-1){
            fos.write(arr, 0, len);
        }
        Scanner s = new Scanner(System.in);
        System.out.println(s.nextLine());
    }
}
