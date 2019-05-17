package com.xu.day23__recursion;

import org.junit.Test;

import java.io.File;

/**
 * 递归实现返回文件夹大小
 */
public class Test1 {
    long size = 0;

    @Test
    public void exe() {
        //System.out.println(fileSize(new File("file.txt")));
        System.out.println(calDirSizePluse(new File("F:\\xrc\\ideaCode\\JavaSE\\.git")));
        //System.out.println(size);
    }

    public void calDirSize(File file) {
        if (file.isFile())
            this.size += file.length();
        else
            for (File f : file.listFiles())
                calDirSize(f);
    }

    public long calDirSizePluse(File file) {
        long len = 0;
        if (file.isFile())
            return len += file.length();//cool！
        else
            for (File f : file.listFiles())
                len += calDirSizePluse(f);
        return len;
    }

    public String fileSize(File file) {
        return file.length() + "字节（byte）";
    }

    /**
     * 返回x
     */
    @Test
    public void test2() {
        System.out.println(haha());
    }

    int haha() {
        int x = 10;
        return x = x + 1;
    }
}
