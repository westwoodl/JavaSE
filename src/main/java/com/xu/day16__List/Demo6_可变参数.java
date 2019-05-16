package com.xu.day16__List;

import org.junit.Test;

/**
 * jdk 1.5新特性
 */
public class Demo6_可变参数 {

    @Test
    public void test(){
        print();
        print(1,2,3,4);
        printx(1,2,3,4);
        print(new int[]{1,2,3,4,5});
    }

    void print(int...arr){//可变参数其实是个数组
        for (int a:arr)
            System.out.println(a);
    }

    void printx(int x, int...arr){//可变参数其实是个数组
        for (int a:arr)
            System.out.println(a);
    }
}
