package com.xu.day21__RW.test;

import org.junit.Test;

import java.io.*;
import java.util.TreeMap;

/**
 * 读取一个文件的字符出现的个数
 */
public class Demo7_test {


    @Test
    public void test() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("file.txt"));

        TreeMap<Character, Integer> tree = new TreeMap<>();
        int b;

        while ((b = br.read()) != -1)
            tree.put((char) b, tree.containsKey((char) b) ? tree.get((char) b) + 1 : 1);


        System.out.println(tree);

        br.close();
    }
}