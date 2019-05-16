package com.xu.day20__IO;

import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 *
 * @see java.io.InputStream
 * @see java.io.OutputStream
 *
 * @see FileInputStream
 * @see FileOutputStream
 */
public class Demo1_FileIOS {

    @Test
    public void test() throws IOException {
        FileInputStream fis = new FileInputStream("file.txt");
        int x;//read 1 byte(8bit)
        /**
         * 为什么read返回int：byte只有8bit，不好通过-1判断文件是否结束
         */
        int readCount = 0;
        while((x = fis.read()) != -1) {
            System.out.println(x);
            System.out.println(++readCount);
        }

        fis.close();
    }
    @Test public void test2() throws IOException {
        //true 追加
        FileOutputStream fos = new FileOutputStream("file.txt", true);
        fos.write(100);//a
        fos.write(98);//b
        fos.write(99);//c



        fos.close();
    }

    @Test
    public void test3() throws IOException {
        FileInputStream fis = new FileInputStream("file.txt");
        byte[] ch = new byte[1024];//read 1 byte(8bit)
        int x;
        /**
         * 为什么read返回int：byte只有8bit，不好通过-1判断文件是否结束
         */
        int readCount = 0;
        while((x = fis.read(ch)) != -1) {
            System.out.println(++readCount);
        }

        fis.close();
    }
}
