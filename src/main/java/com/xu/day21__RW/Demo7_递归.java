package com.xu.day21__RW;

import org.junit.Test;

import java.io.File;

/**
 * 使用递归显示文件夹内的所有文件
 */
public class Demo7_递归 {
    @Test public void test1(){
        haha(new File("F:\\git"), new StringBuffer(""));
    }
    /**
     * 文件夹s 我哭辽，写了挺久，但最终也还是写出来了
     * @param s
     */
    public void haha(File file, StringBuffer t) {
        if (!file.exists()) throw new RuntimeException("没有该文件!");
        else if (file.isFile()) {
            System.out.println(t.append("  |") + file.getName() + "(fil)");
            t.delete(t.length()-3, t.length());
            return;
        }
        if (file.isDirectory()) {
            System.out.println(t.append("  |") + file.getName() + "(dir)");
            for (File f : file.listFiles()) {
                haha(f, t);
            }
            t.delete(t.length()-3, t.length());
        }
    }


    @Test public void teste(){
        StringBuffer s = new StringBuffer("abcv");
        s.deleteCharAt(s.length()-1);
        System.out.println(s);
    }
    /**
     * @throws StackOverflowError
     */
    @Test
    public void test(){
        test(10000000);
    }
    public int test(int x){
        if(x == 0)
            return 0;
        return test(--x);
    }

    @Test public void testxxx(){
        HH.xxxx();
    }
}
abstract class HH{

    public  abstract  void x();

    public static void xxxx(){
        System.out.println("xxx");
    }
}