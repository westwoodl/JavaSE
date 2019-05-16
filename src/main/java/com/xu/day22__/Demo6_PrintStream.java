package com.xu.day22__;

import org.junit.Test;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;

/**
 * 打印流
 * @see PrintStream 即System.out
 * @see PrintWriter
 */
public class Demo6_PrintStream {

    @Test
    public void test(){
        PrintStream ps = System.out;
        ps.println(97);

        ps.write(97);
        ps.close();

    }

    @Test public void test2() throws IOException {
        PrintWriter pw = new PrintWriter(new FileWriter("fil"), true);
        pw.println(100);
        pw.write(92);
        pw.close();
    }
}
