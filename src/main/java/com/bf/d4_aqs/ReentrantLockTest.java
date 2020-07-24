package com.bf.d4_aqs;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author xu rongchao
 * @date 2020-07-15 15:27
 */
public class ReentrantLockTest {


    final static ReentrantLock reentrantLock = new ReentrantLock();
    /**
     * 一个线程 一个condition
     */
    final static Condition condition = reentrantLock.newCondition();
    final static Condition condition2 = reentrantLock.newCondition();

    public static void main(String[] args) {

        Thread t1 = new Thread(() -> {
            reentrantLock.lock();
            try {
                for (; ; ) {
                    System.out.println(1);
                    sleep();
                    condition2.signal();
                    condition.await();
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                reentrantLock.unlock();
            }
        });

        Thread t2 = new Thread(() -> {
            reentrantLock.lock();
            try {
                for (; ; ) {
                    System.out.println(2);
                    sleep();
                    condition.signal();
                    condition2.await();
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                reentrantLock.unlock();
            }
        });

        t1.start();
        t2.start();


    }

    static void sleep() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }



    @Test
    public void test_stream() {
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < 100;i++) {
            list.add(i);
        }

        list.parallelStream().forEach((e)->{
            e = e + 1;
        });

        list.forEach(System.out::println);
    }
}
