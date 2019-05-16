package com.xu.day20__IO;

import org.junit.Test;

import java.io.*;

public class Demo6_图片加密 {

    /**
     * 加密 异或 1^1 = 0  1^0 = 1  0^0 = 0  和同一个数异或两次，变成原数
     * @throws IOException
     */
    @Test public void test() throws IOException {

        try(BufferedInputStream bis = new BufferedInputStream(new FileInputStream("图片加密.png"));
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("copy.png"));
        ) {
            int b;
            while ((b = bis.read()) != -1)
                bos.write(b ^ 123);
        }
    }
    /**
     * 解密
     */
    @Test public void test2() throws IOException {
        try(BufferedInputStream bis = new BufferedInputStream(new FileInputStream("copy.png"));
            BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("copy2.png"));
        ) {
            int b;
            while ((b = bis.read()) != -1)
                bos.write(b ^ 123);
        }
    }
}
