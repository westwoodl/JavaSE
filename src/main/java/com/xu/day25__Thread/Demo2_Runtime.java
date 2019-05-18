package com.xu.day25__Thread;

import org.junit.Test;

import java.io.IOException;

/**
 * @see Runtime 饿汉单例模式
 */
public class Demo2_Runtime {

    @Test public void test() throws IOException, InterruptedException {

        Runtime r = Runtime.getRuntime();
        System.out.println(r.exec("shutdown -s -t 3000"));

        Thread.sleep(5000);
        System.out.println(r.exec("shutdown -a"));
    }


    public static void main(String[] args) throws IOException {
        Runtime.getRuntime().exec("rasdial 宽带连接 15797863002 147703");
    }
}
