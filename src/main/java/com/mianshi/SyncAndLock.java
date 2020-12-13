package com.mianshi;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author xu rongchao
 * @date 2020/12/5 19:25
 */
public class SyncAndLock {

    /**
     * sync 和 lock之间的区别
     *
     * 1. sync是java关键词，lock是类
     * 2. sync不能被中断
     * 3. sync出现异常自动释放锁
     * 4. Synchronized锁升级机制
     * 5. lock有condition
     */
    public static void main(String[] args) throws InterruptedException {
        long  x = 1;
        while (true) {
            if (x % 1000000000 == 0) {
                System.out.println(x);
            }
            if (x++ > 10000000000000000L) {
                break;
            }
        }
        System.out.println("s");
        // 精确唤醒
        ShareResource shareResource = new ShareResource();
        ThreadPoolExecutor pool = new ThreadPoolExecutor(1
                ,10,0
                , TimeUnit.MILLISECONDS
                , new ArrayBlockingQueue<>(1)
                , Executors.defaultThreadFactory()
                , new ThreadPoolExecutor.AbortPolicy());

        pool.execute(shareResource::print10);
        Thread.sleep(2*1000);
        pool.execute(shareResource::print15);
        pool.execute(shareResource::print5);
        pool.execute(()-> {
            System.out.println("dasdsdsa");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            long  i = 1;
            while (true) {
                if (i++ > 10000000000000000L) {
                    break;
                }
            }
            System.out.println("dasdsdsa");
        });
        System.out.println("？");
        // 执行完了shutdown
        pool.shutdown();
        pool.shutdownNow();
    }
}

class ShareResource {
    private int number = 1;
    private Lock lock = new ReentrantLock();

    private Condition c1 = lock.newCondition();
    private Condition c2 = lock.newCondition();
    private Condition c3 = lock.newCondition();

    public void print5() {
        lock.lock();
        try {
            while (number != 1) {
                c1.await();
            }
            System.out.println("A1");
            number = 2;
            c2.signal();

        } catch (Exception ignore) {
        } finally {
            lock.unlock();
        }
    }

    public void print10() {
        lock.lock();
        try {
            while (number != 2) {
                c2.await();
            }
            System.out.println("A2");
            number = 3;
            c3.signal();

        } catch (Exception ignore) {
        } finally {
            lock.unlock();
        }
    }

    public void print15() {
        lock.lock();
        try {
            while (number != 3) {
                c3.await();
            }
            System.out.println("A3");
            number = 1;
            c1.signal();

        } catch (Exception ignore) {
        } finally {
            lock.unlock();
        }
    }

}