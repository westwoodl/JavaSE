package com.xu.day22__prop;

import org.junit.Test;

import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * @see RandomAccessFile#seek(long) 指定读或写的指针位置
 */
public class Demo3_RandomAccessFile {

    @Test
    public void test() throws IOException {
        RandomAccessFile raf = new RandomAccessFile("file.txt", "rw");

        int b;
        b = raf.read();
        System.out.println(b);
        raf.seek(100);

        raf.write(98);

        raf.close();
    }


}
