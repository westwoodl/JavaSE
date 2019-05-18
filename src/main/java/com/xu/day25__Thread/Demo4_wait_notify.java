package com.xu.day25__Thread;

/**
 * @see Object#wait() 使当前线程等待，直到另一个线程调用
 * @see Object#notify() 唤醒正在等待此对象监视器的所有线程
 */
public class Demo4_wait_notify {

    int x = 1;

    void print1() {
        synchronized (this) {
            if (x == 1) {
                try {
                    this.wait();//当前线程等待（释放对象），在此等待，在此开始运行
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.print("h");
            System.out.print("H");
            System.out.println("哈");
            x = 1;
            this.notify();
        }
    }

    void print2() {
        synchronized (this) {
            if (x == 2) {
                try {
                    this.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.print("x");
            System.out.print("X");
            System.out.println("下");
            x = 2;
            this.notify();
        }
    }

    public static void main(String[] args) {
        Demo4_wait_notify d4 = new Demo4_wait_notify();
        new Thread(){
            @Override
            public void run() {
                for (;;)
                    d4.print1();
            }
        }.start();
        new Thread(){
            @Override
            public void run() {
                for (;;)
                    d4.print2();
            }
        }.start();
    }
}
