package com.xu.day21__RW;

import org.junit.Test;

import java.io.*;

/**
 * 为什么BufferedReader每次读一个字符{@link #test2}
 * @see BufferedReader#readLine()
 * @see BufferedWriter#newLine()//写回车换行
 */
public class Demo2_BufferedRW {

    @Test
    public void test() throws IOException {
        try(
        BufferedReader br = new BufferedReader(new FileReader("file.txt"));
        BufferedWriter bw = new BufferedWriter(new FileWriter("file2.txt"));
        ) {
            String line;

            while ((line = br.readLine()) != null) {
                //System.out.println(line);
                bw.write(line);
                bw.newLine();//跨平台的方法
                //bw.write("\r\n");//只支持的windows
            }
        }
    }

    @Test public void test2() throws IOException {
        try(
                BufferedReader br = new BufferedReader(new FileReader("file.txt"));
                BufferedWriter bw = new BufferedWriter(new FileWriter("file2.txt"));
        ) {
            int x;
            int readCount = 0;
            while ((x = br.read())!=-1) {
                System.out.println(x);
                System.out.println((char) x);
                bw.write(x);
                System.out.println(++readCount);//为什么BufferedReader每次读一个字符
            }
        }
    }
}
