package com.xu.day24__Thread;

import org.junit.Test;

/**
 * 运行主线程时，jvm的gc在并发执行（废话。。）
 * @see Thread
 * @see Thread#currentThread()
 */
public class Demo1_jvm {
    @Test
    public void test(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (;;) {
                    System.out.println(Thread.currentThread().getName()+"R");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();

        new Thread(){
            @Override
            public void run() {
                for (;;) {
                    System.out.println(this.getName()+"T");
                    try {
                        this.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }.start();

        Thread.currentThread().setName("主线程");
        System.out.println(Thread.currentThread().getName());
    }

    class MyThread extends Thread{
        @Override
        public void run() {
            super.run();
        }
    }






    public static void main(String[] args) {
//        for (int i=0;i<1000000;i++)
//            new Demo();
//        for (int i=0;i<10000;i++)
//            System.out.print("1");
//        System.out.println("");
//        for (int i=0;i<10000;i++)
//            System.out.print("2");
        new Demo1_jvm().test();
    }
}
class Demo{
    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.print("clean");
    }
}