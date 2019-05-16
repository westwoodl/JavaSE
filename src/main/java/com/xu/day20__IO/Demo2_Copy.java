package com.xu.day20__IO;

import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 提高每次读写的量{@link #copyPlus}，来提高copy{@link #copy}速度
 * @see FileInputStream#available() 获取文件大小
 * @see FileInputStream#read(byte[]) 返回读取数据长度
 */
public class Demo2_Copy {
    @Test
    public void test(){
        //copy("file.txt", "file2.txt");
        try {
            copyPlus("file.txt", "file2.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void copy(String file, String indexFile){
        FileInputStream fis = null;
        FileOutputStream fos = null;
        try {
             fis = new FileInputStream(file);
             fos = new FileOutputStream(indexFile);
            int x;
            while ((x = fis.read())!=-1)
                fos.write(x);
            System.out.println("Copy " + file + " to " + indexFile + " successful");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fis.close();
                fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    private void copyPlus(String s1, String s2) throws IOException{
        FileInputStream fis = null;
        FileOutputStream fos = null;
        byte[] b = new byte[1024];
        try {
            fis = new FileInputStream(s1);
            fos = new FileOutputStream(s2);
            System.out.println(fis.available());

            int len;
            //System.out.println(fis.read(b));
            while((len = fis.read(b))!=-1)
                fos.write(b, 0, len);
            System.out.println("Copy " + s1 + " to " + s2 + " successful");
        } finally {
            try {
                try {
                    if (fis != null)
                        fis.close();
                }finally {
                    if(fos!=null)
                        fos.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
