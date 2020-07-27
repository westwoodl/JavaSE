package com.bf.d5_queue;

import java.util.concurrent.PriorityBlockingQueue;

/**
 * @author xu rongchao
 * @date 2020-07-27 17:13
 */
public class PriorityBlockingQueueTest {
    /**
     * 带优先级的无界阻塞队列，每次出队都返回最高或最低。内部使用平衡二叉树堆实现，直接遍历不保证有序（大顶堆）
     * \独占锁来控制同时只有一个线程可以进行入队和出队操作
     * notEmpty控制出队阻塞
     * 因为是无界的 所以没有使用notFull控制入队操作
     * @param args
     */
    public static void main(String[] args) {
        PriorityBlockingQueue<Integer> priorityBlockingQueue = new PriorityBlockingQueue<>();
        priorityBlockingQueue.offer(1);
        priorityBlockingQueue.offer(2);
        priorityBlockingQueue.offer(6);
        priorityBlockingQueue.offer(4);
        priorityBlockingQueue.forEach(System.out::println);

        priorityBlockingQueue.offer(0);

        priorityBlockingQueue.forEach(System.out::println);
        priorityBlockingQueue.poll();
    }
}
