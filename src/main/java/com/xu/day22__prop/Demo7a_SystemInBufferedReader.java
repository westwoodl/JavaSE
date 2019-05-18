package com.xu.day22__prop;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * System.in是一个字节流，使用转换流InputStreamReader转换为字符流
 * 深入理解Scanner，Scanner更加强大
 * @see InputStreamReader
 */
public class Demo7a_SystemInBufferedReader {

    public static void main(String[] args) throws IOException {
        try(
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            for (;;)
                System.out.println(br.readLine());
        }
    }
}
