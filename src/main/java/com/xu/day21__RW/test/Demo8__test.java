package com.xu.day21__RW.test;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * 读取数字
 */
public class Demo8__test {

    @Test
    public void test() throws IOException{
        BufferedReader br = new BufferedReader(new FileReader("file.txt"));
        System.out.println(br.readLine());
        br.close();
    }

    @Test public void test2() throws IOException{
        try(FileReader fr = new FileReader("file.txt");){
            System.out.println((char) fr.read());System.out.println((char) fr.read());
        }
    }
}
