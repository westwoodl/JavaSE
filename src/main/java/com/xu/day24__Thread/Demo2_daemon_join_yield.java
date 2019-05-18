package com.xu.day24__Thread;

import org.junit.Test;

/**
 * 守护线程：{@link #testDaemon()}
 *      其他线程关闭后，守护线程自动关闭
 * @see Thread#setDaemon(boolean)
 *
 * 线程插队：{@link #test_join()}
 *     匿名内部类使用局部变量，局部变量必须被final修饰
 * @see Thread#join()
 *
 * 礼让线程:{@link #test_yield()}
 *     理论上的让出cpu
 * @see Thread#yield()
 */
public class Demo2_daemon_join_yield {

    @Test
    public void testDaemon() {
        new Thread() {
            @Override
            public void run() {
                for (int n = 0; n < 2; n++)
                    System.out.println("aaa");
            }
        }.start();

        Thread t2 = new Thread() {
            @Override
            public void run() {
                for (int n = 0; n < 50; n++)
                    System.out.println("bbb");
            }
        };
        t2.setDaemon(true);
        t2.start();

    }

    @Test
    public void test_join() {
        final Thread t1 = new Thread() {
            @Override
            public void run() {
                for (int n = 0; n < 50; n++)
                    System.out.println("aaa");
            }
        };
        t1.start();

        Thread t2 = new Thread() {
            @Override
            public void run() {
                for (int n = 0; n < 50; n++) {
                    if (n == 5) {
                        try {
                            //t1.join();
                            t1.join(2);//指定插队时间，过了时间，交替进行
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.println("bbb");
                }
            }
        };
        t2.start();

    }

    @Test
    public void test_yield() {
        final Thread t1 = new Thread() {
            @Override
            public void run() {
                for (int n = 0; n < 5000; n++) {
                    System.out.println(getName() + "a:" + n);
                }
            }
        };
        t1.start();

        Thread t2 = new Thread() {
            @Override
            public void run() {
                for (int n = 1; n < 5000; n++) {
                    System.out.println(getName() + "b:" + n);
                    if (n % 10 == 0) yield();
                }
            }
        };
        t2.start();
    }

    public static void main(String[] args) {
        //new Demo2_daemon_join_yield().testDaemon();
        Demo2_daemon_join_yield dd = new Demo2_daemon_join_yield();
        //dd.test_join();
        dd.test_yield();
    }
}
