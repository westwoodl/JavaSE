package com.xu.day22__;

import org.junit.Test;

import java.io.*;
import java.util.Enumeration;
import java.util.Vector;

/**
 * 序列流（合并流）
 * 多个流整合成一个流读取文件
 * @see SequenceInputStream#SequenceInputStream(InputStream, InputStream) {@link #test}
 * @see SequenceInputStream#SequenceInputStream(Enumeration) {@link #test2()}
 */
public class Demo1_SequenceInputStream {
    @Test public void test2() throws IOException {
        try (
                FileInputStream fis1 = new FileInputStream("file.txt");
                FileInputStream fis2 = new FileInputStream("file.txt");
                FileInputStream fis3 = new FileInputStream("file.txt");
        ) {
            Vector<FileInputStream> v = new Vector<>();
            v.add(fis1);
            v.add(fis2);
            v.add(fis3);
            Enumeration<FileInputStream> e = v.elements();

            try (
                    SequenceInputStream sis = new SequenceInputStream(e);
                    FileOutputStream fos = new FileOutputStream("file2.txt");
            ) {
                int b;
                while ((b = sis.read()) != -1)
                    fos.write(b);
            }
        }
    }

    @Test
    public void test() throws IOException {
        try (
                SequenceInputStream sis = new SequenceInputStream(
                        new FileInputStream("file.txt"), new FileInputStream("file.txt"));
                FileOutputStream fos = new FileOutputStream("file2.txt");
        ) {
            byte[] bytes = new byte[1024];
            int len;
            while ((len = sis.read(bytes)) != -1) {
                fos.write(bytes, 0, len);
                for (byte b : bytes) System.out.println((char) b);
            }
        }

    }
}
