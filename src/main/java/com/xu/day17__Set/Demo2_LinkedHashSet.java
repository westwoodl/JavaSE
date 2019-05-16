package com.xu.day17__Set;

import org.junit.Test;

import java.util.LinkedHashSet;

/**
 * 链表实现，取出的顺序是存入的顺序
 */
public class Demo2_LinkedHashSet {
    LinkedHashSet<Integer> s;

    @Test
    public void test(){
        s = new LinkedHashSet();
        s.add(2);s.add(2);s.add(3);s.add(4);
        System.out.println(s);

        //s.addAll();
    }
}
