package com.bf.d3_copy_on_write;

import org.junit.Test;

import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @author xu rongchao
 * @date 2020-07-13 14:36
 */
public class CopyOnWriteArrayListTest {
    /**
     * 线程安全的ArrayList ，对其进行的修改操作都是在底层的一个复制的数组（快照）上进行的
     * 就是使用了写时复制策略。
     */

    @Test
    public void testCopyOnWriteArrayList() {
        CopyOnWriteArrayList<Integer> cowList = new CopyOnWriteArrayList<>();

        cowList.add(1);
        cowList.remove(1);


    }
}
