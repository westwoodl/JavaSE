package com.bf.d5_queue;

import java.util.concurrent.ArrayBlockingQueue;

/**
 * 有界数组实现的阻塞队列
 * @author xu rongchao
 * @date 2020-07-24 16:32
 */
public class ArrayBlockingQueueTest {

    public static void main(String[] args) {
        // 必须定义初始大小
        ArrayBlockingQueue<Integer> arrayBlockingQueue = new ArrayBlockingQueue<>(20);

        // offer 不阻塞 满则丢
        arrayBlockingQueue.offer(1);
        // put 满则阻塞
        try {
            arrayBlockingQueue.put(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // poll 获取然后移除 不阻塞
        System.out.println(arrayBlockingQueue.poll());
        // take 获取然后移除 阻塞
        try {
            arrayBlockingQueue.take();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //


    }

}
