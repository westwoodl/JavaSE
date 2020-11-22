package com.bf.d7_高级并发;

import java.util.concurrent.*;

/**
 * @author xu rongchao
 * @date 2020-11-04 10:42
 */
public class CyclicBarrierTest {

    /**
     * await达到2 时调用 runnable
     * 通过独占锁 ReentrantLock 实现计数器原子性更新，并使用条件变量队列来实现线程同步。
     */
    private static final CyclicBarrier cyclicBarrier = new CyclicBarrier(2, new Runnable() {
        @Override
        public void run() {
            System.out.println("突破屏障");
        }
    });

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        executorService.submit(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread());
                try {
                    cyclicBarrier.await();
                    System.out.println(Thread.currentThread() + "end");
                } catch (InterruptedException | BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }
        });

        executorService.submit(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread());
                try {
                    Thread.sleep(5000);
                    cyclicBarrier.await();
                    System.out.println(Thread.currentThread() + "end");
                } catch (InterruptedException | BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }
        });
        executorService.shutdown();
    }
}
