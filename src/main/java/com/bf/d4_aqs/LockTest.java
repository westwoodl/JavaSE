package com.bf.d4_aqs;

import org.junit.Test;

import java.util.concurrent.*;
import java.util.concurrent.locks.LockSupport;

/**
 * @author xu rongchao
 * @date 2020-07-13 15:29
 */
public class LockTest {



    @Test
    public void test_lock_support() throws InterruptedException {

        Thread t1 = new Thread(() -> {
            System.out.println ("child thread begin park");
            LockSupport.park();
            System.out.println ("child thread begin unpark");

        });
        t1.start();
        Thread.sleep(1000);
        System.out.println ("main thread begin park");
//        LockSupport.unpark(t1) ;
        Thread.sleep(1000);
        t1.interrupt();

    }

    public static void main(String[] args) {
        System.out.println("1");
        ExecutorService executor = new ThreadPoolExecutor(0
                , 3
                , 10L
                , TimeUnit.SECONDS
                , new SynchronousQueue<>()
                , e -> {
            Thread t = new Thread(e);
            t.setName("线程" + t.getName());
            return t;
        });

        executor.execute(() -> {
            for (;;) {
                System.out.println(Thread.currentThread().getName());
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        executor.execute(() -> {
            for (;;) {
                System.out.println(Thread.currentThread().getName());
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        executor.execute(() -> {
            for (;;) {
                System.out.println(Thread.currentThread().getName());
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        



    }
}
