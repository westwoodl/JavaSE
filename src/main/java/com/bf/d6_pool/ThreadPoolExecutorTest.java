package com.bf.d6_pool;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author xu rongchao
 * @date 2020/7/25 21:36
 */
public class ThreadPoolExecutorTest {

    /**
     * 当前线程数表示 HashSet<Worker>的 size
     * 当前线程数 < corePoolSize : addWorker
     * corePoolSize < 当前线程数 < maximumPoolSize : 将线程加入阻塞队列里
     * maximumPoolSize < 当前线程数 ：执行拒绝略
     *
     * worker 中有两个变量：
     *     firstTask：为executor中的Runnable对象
     *     thread：此线程为ThreadFactory创建的线程，在addWork时会start此线程，执行work中的run方法
     *
     * （getTask和addWork（null， false）遥相呼应）
     * Q. 线程池是什么时候创建线程的？
     * A.任务提交的时候
     *
     * Q.任务runnable task是先放到core到maxThread之间的线程，还是先放到队列？
     * A.先放队列!!!
     *
     * Q. 队列中的任务是什么时候取出来的？
     * A. worker中 runWorker() 一个任务完成后，会取下一个任务runWorker 中的getTask方法
     *
     * Q. 什么时候会触发reject策略？
     * A.队列满并且maxthread也满了， 还有新任务，默认策略是reject
     *
     * Q. core到maxThread之间的线程什么时候会die?
     * A.  没有任务时，或者抛异常时。
     *
     *    core线程也会die的，core到maxThread之间的线程有可能会晋升到core线程区间，
     *    core max只是个计数，线程并不是创建后就固定在一个区间了
     * Q. task抛出异常，线程池中这个work thread还能运行其他任务吗?
     * A. 不能。 但是会创建新的线程, 新线程可以运行其他task。
     */
    public static void main(String[] args) {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(
                2
                , 10
                , 0
                , TimeUnit.MILLISECONDS
                , new ArrayBlockingQueue<>(10)
                , (ThreadFactory) Thread::new
        );

        threadPoolExecutor.execute(() -> {
            for (;;) {
                System.out.println(Thread.currentThread().getName() + "hh");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        threadPoolExecutor.execute(() -> {
            for (;;) {
                System.out.println(Thread.currentThread().getName() + "hh");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
