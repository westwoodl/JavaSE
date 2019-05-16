package com.xu.day21__RW;

import org.junit.Test;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * 字符流：适用于只读或只写纯文本文件，不可拷贝非文本文件（非字符会以问好代替）
 *    读取时读取字节，然后转换为字符{@link #test}，
 *    写的时候，将字符转换为字节{@link #test2()}
 *    自定义缓存区大小{@link #test3}
 *
 * @see java.io.FileReader 每次读一个字符char
 * @see java.io.FileWriter 一次写1024 char
 * @see java.io.Writer char[1024] 2k缓冲区
 */
public class Demo1_FileRW {

    @Test
    public void test() throws IOException {
        try(FileReader fr = new FileReader("file.txt")){
            int x;
            int readCount = 0;
            while((x = fr.read())!=-1) {
                System.out.print((char) x);
                System.out.println(++readCount);
            }
        }
    }

    @Test public void test2() throws IOException{
        try(FileWriter fw = new FileWriter("file.txt", true);){
            fw.write("妹妹\r\n，不是哥哥不爱宁，只是哥哥没有那个棱赖");
        }
    }

    @Test public void test3() throws IOException{
        try(
                FileReader fr = new FileReader("file.txt");
                FileWriter fw = new FileWriter("file2.txt", true);
                ) {
            char[] c = new char[1024 * 8];
            int len;
            int readCount = 0;
            while ((len = fr.read(c)) != -1) {
                fw.write(c, 0, len);
                System.out.println(len);
                System.out.println(++readCount);
            }
        }
    }
}
