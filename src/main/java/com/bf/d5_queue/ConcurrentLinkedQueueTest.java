package com.bf.d5_queue;

import org.junit.Test;

import java.util.AbstractQueue;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * @author xu rongchao
 * @date 2020-07-14 18:03
 */
public class ConcurrentLinkedQueueTest {

    /**
     * 使用 CAS 算法实现的非阻塞队列 ConcurrentLinkedQueue
     * 写时使用cas，失败则重新寻找tail 循环，所以读size时的数据不精确
     * 写好 读不太精确
     *
     * poll 获取并移除
     * peek 获取队头
     */
    @Test
    public void test() {

        ConcurrentLinkedQueue<Integer> concurrentLinkedQueue = new ConcurrentLinkedQueue<>();
        concurrentLinkedQueue.add(1);
        concurrentLinkedQueue.offer(2);

    }
}
