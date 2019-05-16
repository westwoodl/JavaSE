package com.xu.day12;

import org.junit.Test;

/**
 * String是引用类型
 * String类型实现了设计模式中的享元模式
 * null可以给任意的引用类型赋值
 * Strings are constant; their values cannot be changed after they
 * are created. String buffers support mutable strings.
 */
public class StringDemo {
    @Test
    public void exe(){

        String a = new String("ABC");//堆
        String b = new String("ABC");
        System.out.println(a==b);
        System.out.println(a.equals(b));
        String a1 = "abc";
        String b1 = "ab";
        b1 = b1+"c";
        System.out.println(a1==b1);
        System.out.println(a1.equals(b1));

        String a2 = "a"+"b"+"c";//java的常量优化机制，在编译时就计算出来了
        String b2 = "abc";
        System.out.println(a2==b2);
        String x = null;

        System.out.println("a b   c  ".trim());

        "string转换成字符数组".toCharArray();
        "截取字符串".substring(2);


    }

    //their values cannot be changed after they are created.
    @Test public void testStringIsYinyongleiXingMa(){
        String s = "haha";
    }
}
