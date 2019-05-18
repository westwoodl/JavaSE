package com.xu.day22__prop;

import org.junit.Test;

import java.io.*;

/**
 * 打印流
 * @see PrintStream 即System.out
 * @see PrintWriter#PrintWriter(Writer)  将文件字符写到控制台
 */
public class Demo6_PrintStream {
    @Test
    public void test() {
        PrintStream ps = System.out;
        ps.println(97);

        ps.write(97);
        ps.close();
    }

    @Test
    public void test2() throws IOException {
        PrintWriter pw = new PrintWriter(new FileWriter("file.properties"), true);
        pw.println(100);
        pw.write(92);
        pw.close();
    }
}
