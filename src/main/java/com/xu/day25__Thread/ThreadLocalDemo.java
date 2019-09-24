package com.xu.day25__Thread;

/**
 * 每个线程都有一个ThreadLocal
 */
public class ThreadLocalDemo {

    public static void main(String[] args) {
        ThreadLocal<String> threadLocal = new ThreadLocal<>();
        final String[] x = {""};
        Thread.currentThread().setName("主线程");
        new Thread(new Runnable() {
            @Override
            public void run() {
                threadLocal.set("xyz");
                x[0] = x[0] + "x";
                System.out.println(x[0] + "----" + Thread.currentThread().getName());
                System.out.println(threadLocal.get() + "----" + Thread.currentThread().getName());
            }
        }).start();

        new Thread(() -> {
            System.out.println(x[0] + "----" + Thread.currentThread().getName());
            //threadLocal.set("1");
            System.out.println(threadLocal.get() + "----" + Thread.currentThread().getName());
        }).start();
    }
}
