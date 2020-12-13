package com.bf.d4_aqs;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author xu rongchao
 * @date 2020-07-16 16:43
 */
public class ReentrantReadWritelockTest {

    static ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();

    /**
     * 1.允许多读
     * 2.写只允许一个，写时不能
     * 3.写时不能读，读时不能写
     * <p>
     * 使用state的高16位表示读状态，也就是获取到读锁的次数；使用低16位表示获取到写锁
     * 的线程的可重入次数
     *
     * @param args
     */
    public static void main(String[] args) {

        ThreadPoolExecutor pool = new ThreadPoolExecutor(10, 10, 0L, TimeUnit.MILLISECONDS,
                new ArrayBlockingQueue<>(10), (ThreadFactory) Thread::new);


        pool.execute(ReentrantReadWritelockTest::read);
        pool.execute(ReentrantReadWritelockTest::read);
        pool.execute(ReentrantReadWritelockTest::read);
        pool.execute(ReentrantReadWritelockTest::write);
        pool.execute(ReentrantReadWritelockTest::read);
        pool.execute(ReentrantReadWritelockTest::write);
        pool.execute(ReentrantReadWritelockTest::read);
        pool.execute(ReentrantReadWritelockTest::read);
        pool.execute(ReentrantReadWritelockTest::write);
        pool.execute(ReentrantReadWritelockTest::read);
        pool.execute(ReentrantReadWritelockTest::write);
        pool.execute(ReentrantReadWritelockTest::read);
        pool.execute(ReentrantReadWritelockTest::read);

        System.out.println("-");
    }

    public static void read() {
        reentrantReadWriteLock.readLock().lock();
        try {
            System.out.println(Thread.currentThread() + "reading");
            Thread.sleep(5 * 1000);
            System.out.println(Thread.currentThread() + "read done");
        } catch (Exception ignored) {
        } finally {
            reentrantReadWriteLock.readLock().unlock();
        }
    }


    public static void write() {
        reentrantReadWriteLock.writeLock().lock();
        try {
            System.out.println(Thread.currentThread() + "writing");
            Thread.sleep(10 * 1000);
            System.out.println(Thread.currentThread() + "write done");
        } catch (Exception ignored) {
        } finally {
            reentrantReadWriteLock.writeLock().unlock();
        }
    }
}
