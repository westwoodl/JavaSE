package com.xu.day22__prop;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * 内存输出流：
 *     将读取到的数据，逐个写入byte[](内存)
 *     没有io操作，close是个空方法
 * @see ByteArrayOutputStream
 * @see java.io.ByteArrayInputStream
 */
public class Demo2_ByteArrayOutputStream {

    @Test
    public void test() throws IOException {
        FileInputStream fis = new FileInputStream("file.txt");
        ByteArrayOutputStream baos = new ByteArrayOutputStream();

        int b;
        while ((b = fis.read())!=-1)
            baos.write(b);

        //可以自定义码表
        //byte[] bytes = baos.toByteArray();
        //System.out.println(new String(bytes, 0, bytes.length));

        System.out.println(baos);

        fis.close();
    }
}
