package com.xu.day13__SB_Arrays;

import org.junit.Test;

import java.lang.reflect.Array;

/**
 * 数组
 */
public class StringBufferDemo {
    StringBuffer b;
    Array a;

    @Test public void testToStringCache(){
        b = new StringBuffer();
        System.out.println(b);

        b.append("haha");
        System.out.println("1111"+b);

        b.insert(2, "*");
        System.out.println("222"+b);

        b.insert(2, 2);
        System.out.println("333"+b);

        new String(new StringBuffer("haha"));

        b.substring(1);//new String be created
        b.reverse();

        System.out.println(b);
        System.out.println(b.capacity()+" "+b.length());
    }
}
