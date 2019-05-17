package com.xu.day23__recursion;

import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 将文件夹1，复制到文件夹2中{@link #copy(File, File)}
 */
public class Test2 {
    @Test
    public void exe() {
        File f1 = new File("F:\\cao\\f1");
        File f2 = new File("F:\\cao\\f2");
        try {
            if(f2.isFile()) throw new RuntimeException(f2.getAbsolutePath()+"不是文件夹！");
            if(!f1.exists()||!f2.exists()) throw new RuntimeException("文件不存在");
            copy(f1, f2);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * f2，必须为文件夹
     *
     * @param f1 源文件夹
     * @param f2 目标文件夹
     */
    void copy(File f1, File f2) throws IOException {
        if (f1.isFile()) {//f1是文件则在f2中创建与f1同名的文件
            File file2 = new File(f2.getAbsolutePath() + "\\" + f1.getName());
            if (!file2.exists())
                file2.createNewFile();
            try (
                    FileInputStream fis = new FileInputStream(f1);
                    FileOutputStream fos = new FileOutputStream(file2);
            ) {
                byte[] bytes = new byte[1024];
                int len;
                while ((len = fis.read(bytes)) != -1)
                    fos.write(bytes, 0, len);
            }
        } else {//f1 = dir
            File f4 = new File(f2.getAbsolutePath() + "\\" + f1.getName());
            if (!f4.exists())
                f4.mkdir();
            for (File f3 : f1.listFiles())
                copy(f3, f4);
        }
    }

    @Test
    public void test() {
        File f1 = new File("F:\\cao\\f1");
        File f2 = new File("F:\\cao\\f2");
        System.out.println(f2.getAbsolutePath());
        new File(f2.getAbsolutePath() + "\\" + f1.getName()).mkdir();
    }


}
