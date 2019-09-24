package com.xu.day25__atomic;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 数的原子性操作————atomic包：
 * 在多线程的场景中，我们需要保证数据安全，就会考虑同步的方案，
 * 通常会使用synchronized或者lock来处理，使用了synchronized意
 * 味着内核态的一次切换。这是一个很重的操作。
 *
 * 有没有一种方式，可以比较便利的实现一些简单的数据同步，
 * 比如计数器等等。concurrent包下的atomic提供我们这么一种轻量
 * 级的数据同步的选择
 */
public class Demo1Atomic {

    /**
     * atomic的大概实现原理是：
     * 通过CAS乐观锁保证原子性，通过自旋保证当次修改的最终修改成功，
     * 通过降低锁粒度（多段锁）增加并发性能。
     */
    public static void main(String[] args) throws InterruptedException {
        IncreThread i1 = new IncreThread();
        IncreThread i2 = new IncreThread();

        i1.start();
        i2.start();

        Thread.sleep(500);
        System.out.println(IncreThread.ai);


    }

}

/**
 * atomic 乐观锁
 * @see java.util.concurrent.atomic
 */
class AtomicIncreThread extends Thread {

    static AtomicInteger ai=new AtomicInteger(0);

    public void run() {
        for (int m = 0; m < 1000000; m++) {
            ai.getAndIncrement();
        }
    }
}

class IncreThread extends Thread {

    static Integer ai=new Integer(0);

    public void run() {
        for (int m = 0; m < 1000000; m++) {

            ai = ai + 1;
        }
    }
}
