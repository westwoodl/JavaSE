package com.bf.d5_queue;

import java.util.concurrent.LinkedBlockingQueue;

/**
 * @author xu rongchao
 * @date 2020-07-14 18:35
 */
public class LinkedBlockingQueueTest {
    public static void main(String[] args) {
        LinkedBlockingQueue<Integer> linkedBlockingQueue = new LinkedBlockingQueue<>();
        linkedBlockingQueue.offer(1);

        System.out.println(linkedBlockingQueue.peek());
        System.out.println(linkedBlockingQueue.peek());
    }
}
