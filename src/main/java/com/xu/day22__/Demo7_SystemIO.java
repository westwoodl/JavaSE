package com.xu.day22__;

import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

/**
 * 不用close，没有和硬盘上的文件产生关系（IO）
 * @see System#in 单例模式
 * @see System#out PrintStream
 */
public class Demo7_SystemIO {


    /**
     * Scanner 就是个包装类
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        InputStream is = System.in;

        byte[] bytes = new byte[32];
        for(;;) {
            int x = is.read(bytes);
            System.out.println(new String(bytes, 0, x));
        }
    }

}
