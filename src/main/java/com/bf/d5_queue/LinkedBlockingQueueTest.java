package com.bf.d5_queue;

import java.util.concurrent.LinkedBlockingQueue;

/**
 * {@link java.util.concurrent.BlockingQueue}
 * 使用独占锁实现
 * 通过两个ReentrantLock 控制元素入队和出队的原子性
 *
 * 当队列为空时，执行出队操作的线程会在notEmpty条件队列等待
 * 当队列为满时，执行入队操作的线程会在notFull条件队列等待
 *
 * 使用条件队列存放被阻塞的线程，结合入队和出队操作实现了一个生产消费模型
 *
 * @author xu rongchao
 * @date 2020-07-14 18:35
 */
public class LinkedBlockingQueueTest {
    public static void main(String[] args) {
        LinkedBlockingQueue<Integer> linkedBlockingQueue = new LinkedBlockingQueue<>();
        linkedBlockingQueue.offer(1);

        System.out.println(linkedBlockingQueue.peek());
        System.out.println(linkedBlockingQueue.peek());

        // 插入 有则返回null
        linkedBlockingQueue.offer(2);
        try {
            // 插入 有则阻塞
            linkedBlockingQueue.put(12);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // 不阻塞的获取移除
        System.out.println(linkedBlockingQueue.poll());
        // 不阻塞的获取
        System.out.println(linkedBlockingQueue.peek());
        // 阻塞移除
        try {
            System.out.println(linkedBlockingQueue.take());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // remove

        /**
         * 由于进行出队、入队操作时的 count 是加了锁的 所以结果相比 ConcurrentLinkedQueue
         * size 方法比较准确 这里考虑为何在 ConcurrentLinkedQueue 中需要遍历链表来获取 size
         * 而不想以下方法一样使用一个原子变量呢？这是因为使用原子变量保存队列元素个数需要保证入队、出队
         * 操作和原子变量操作是原子性操作，而ConcurrentLinkedQueue 使用的 CAS 无锁算法
         * 所以无法做到这样 （他们的cas时是原子性的，但是修改 link同时修改size是无法做到的）
         */
        linkedBlockingQueue.size();
    }
}
