package com.xu.day21__RW;

import org.junit.Test;

import java.io.*;

/**
 * 转换流：将字节流转换为字符流
 * 默认编码表为gbk
 * 指定编码表的读写
 * @see InputStreamReader
 * @see OutputStreamWriter
 */
public class Demo6_IOSRW转换流 {
    @Test
    public void test() throws IOException {

        InputStreamReader isr =
                new InputStreamReader(new FileInputStream("utf-8.txt"), "utf-8");
        OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream("gbk.txt"), "gbk");
    }

    @Test
    public void test2() throws IOException {
        BufferedReader br =
                new BufferedReader(new InputStreamReader(new FileInputStream("utf-8.txt"), "utf-8"));
        BufferedWriter bw =
                new BufferedWriter(new OutputStreamWriter(new FileOutputStream("gbk.txt"), "gbk"));
    }
}
