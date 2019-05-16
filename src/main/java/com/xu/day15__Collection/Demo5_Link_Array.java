package com.xu.day15__Collection;

import org.junit.Test;

import java.util.LinkedList;

/**
 * LinkedList：增删快  为什么查询慢：查看LinkedList的node方法，一目了然
 *
 * ArrayList：查询遍历快，（增加会导致内存浪费，其实为数组）
 *
 * 使用场景：增删改查需求都多时，使用ArrayList
 */
public class Demo5_Link_Array {

    @Test
    public void h(){

        LinkedList  l = new LinkedList();
        l.getFirst();l.getLast();//
    }
}
