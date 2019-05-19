package com.xu.day25__Thread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 重入锁 jdk5新特性，一知半解...
 * @see java.util.concurrent.CountDownLatch
 * @see ReentrantLock
 */
public class Demo6_ReentrantLock {
    private static ReentrantLock r = new ReentrantLock();
    /**
     * 你他妈的怎么知道哪个线程对应对应那个Condition
     */
    private static Condition c1 = r.newCondition();
    private static Condition c2 = r.newCondition();
    private static Condition c3 = r.newCondition();

    static int x = 1;

    static void print1() throws InterruptedException {
        System.out.println(c1);
        System.out.println(c2);
        System.out.println(c3);
        r.lock();
        if (x != 1) {
            c1.await();
        }
        System.out.print("1h");
        System.out.print("H");
        System.out.println("哈");
        x = 2;
        c2.signal();
        r.unlock();
    }

    static void print2() throws InterruptedException {
        r.lock();
        if (x != 2) {
            c2.await();
        }
        System.out.print("2x");
        System.out.print("X");
        System.out.println("下");
        x = 3;
        c3.signal();
        r.unlock();
    }

    static void print3() throws InterruptedException {
        r.lock();
        if (x != 3) {
            c3.await();
        }
        System.out.print("3y");
        System.out.print("Y");
        System.out.println("有");
        x = 1;
        c1.signal();
        r.unlock();
    }

    public static void main(String[] args) {

        new Thread() {
            @Override
            public void run() {
                for (; ; ) {
                    try {
                        print1();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }.start();
        new Thread() {
            @Override
            public void run() {
                for (; ; ) {
                    try {
                        print2();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }.start();
        new Thread() {
            @Override
            public void run() {
                for (; ; ) {
                    try {
                        print3();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }.start();
    }
}
