package com.xu.day20__IO;

import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 不捕获异常，但是我们try finally，以此关闭流
 * jdk7 自动关流写法,我觉得挺好
 */
public class Demo5_TryFinally {
    @Test public void test(){
        try {
            testJDK7("file.txt", "file2.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    /**
     * fis fos具备自动关闭的功能(implements AutoCloseable)，可以写在小括号内
     * @see AutoCloseable
     * @since JDK7
     * @throws IOException
     */
    void testJDK7(String s1, String s2) throws IOException{
        try(FileInputStream fis = new FileInputStream(s1);
            FileOutputStream fos = new FileOutputStream(s2);
            MyClose myClose = new MyClose();){

        }
    }


    /**
     * JDK6版本及其之前这样写
     * @throws IOException
     */
    void testJDK6(String s1, String s2) throws IOException{
        FileInputStream fis = null;
        FileOutputStream fos = null;
        try{
            fis = new FileInputStream(s1);
            fos = new FileOutputStream(s2);
        }finally {
            try {
                if (fis != null)
                    fis.close();
            }finally {
                if (fos != null)
                    fos.close();
            }
        }
    }
}
class MyClose implements AutoCloseable{

    @Override
    public void close() throws IOException {
        System.out.println("I'm closed");
    }
}