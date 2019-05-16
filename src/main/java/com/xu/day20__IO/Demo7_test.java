package com.xu.day20__IO;

import org.junit.Test;

import java.io.*;
import java.util.Scanner;

public class Demo7_test {
    public static void main(String[] args) {
        try {
            new Demo7_test().test();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test() throws IOException {
        File file = getFile();
        try(
                BufferedInputStream bis = new BufferedInputStream(new FileInputStream(file));
                BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(file.getName()));
        ){
            int b;
            while ((b = bis.read())!=-1)
                bos.write(b);
        }
    }

    public File getFile() {
        File file;
        try (Scanner sc = new Scanner(System.in);) {
            while (true) {
                String line = sc.nextLine();
                file = new File(line);
                if (file.isFile())
                    return file;
                System.out.println("不是文件！，重新输入");
            }
        }
    }

    /**
     * 将控制台的数据录入file.txt
     */
    @Test public void test2() throws IOException {
        System.out.println("输入quit退出编辑");
        try(
            FileOutputStream fos = new FileOutputStream("file.txt");
            Scanner sc = new Scanner(System.in);
        ){
            while (true) {
                System.out.print("<<");
                String line = sc.nextLine();
                if("quit".equals(line))break;
                fos.write((line+"\r\n").getBytes());
            }
            System.out.println("Quited");
        }
    }
}
