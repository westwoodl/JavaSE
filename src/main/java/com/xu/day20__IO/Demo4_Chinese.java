package com.xu.day20__IO;

import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Demo4_Chinese {

    @Test
    public void test(){
        try {
            copyChinese("file.txt", "file2.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    void copyChinese(String s1, String s2) throws IOException {
        FileInputStream fis = new FileInputStream(s1);
        FileOutputStream fos = new FileOutputStream(s2);
        byte[] b = new byte[4];
        int len;
        while ((len = fis.read(b)) != -1) {
            fos.write(b, 0, len);
            /*
            输出会出现问题
             */
            System.out.println(new String(b, 0, len));

        }

        fos.write("写入中文".getBytes("utf-8"));
        fos.close();
        fis.close();
    }
}
