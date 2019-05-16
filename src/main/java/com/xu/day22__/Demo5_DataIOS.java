package com.xu.day22__;

import org.junit.Test;

import java.io.*;

/**
 * 数据输入输出流，用的少
 * io基本类型
 */
public class Demo5_DataIOS {

    @Test
    public void test() throws IOException {
        try (
                DataOutputStream dos = new DataOutputStream(new FileOutputStream("file.txt"));
                DataInputStream dis = new DataInputStream(new FileInputStream("file.txt"));
        ) {
            dos.writeBoolean(true);
            dos.writeInt(213789);
            dos.writeDouble(1.1);

            System.out.println(dis.readBoolean());
            System.out.println(dis.readInt());
            System.out.println(dis.readDouble());

        }

    }
}
