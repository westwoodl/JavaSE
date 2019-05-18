package com.xu.day24__Thread;

import org.junit.Test;

/**
 * 设置线程优先级
 * @see Thread#setPriority(int)
 */
public class Demo3_priority {

    @Test
    public void test_setPriority() {
        final Thread t1 = new Thread() {
            @Override
            public void run() {
                for (int n = 0; n < 5000; n++) {
                    System.out.println(getName() + "a:" + n);
                }
            }
        };

        Thread t2 = new Thread() {
            @Override
            public void run() {
                for (int n = 1; n < 5000; n++) {
                    System.out.println(getName() + "b:" + n);
                }
            }
        };
        t1.setPriority(Thread.MAX_PRIORITY);
        t2.setPriority(Thread.MIN_PRIORITY);


        t2.start();
        t1.start();

    }

    public static void main(String[] args) {
        Demo3_priority dp = new Demo3_priority();
        dp.test_setPriority();
    }
}
