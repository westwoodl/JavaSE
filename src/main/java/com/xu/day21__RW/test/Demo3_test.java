package com.xu.day21__RW.test;

import org.junit.Test;

import java.io.*;

/**
 * 倒着读取文本
 */
public class Demo3_test {

    @Test
    public void test()throws IOException {
        try(
                BufferedReader br = new BufferedReader(new FileReader("file.txt"));
                BufferedWriter bw = new BufferedWriter(new FileWriter("file2.txt"));
        ){

        }
    }
}
