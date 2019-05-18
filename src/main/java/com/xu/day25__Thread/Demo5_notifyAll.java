package com.xu.day25__Thread;

/**
 * 唤醒所有
 * @see Object#notifyAll()
 */
public class Demo5_notifyAll {
    int x = 1;
    void print1() {
        synchronized (this) {
            while (x != 1) {
                try {
                    this.wait();//当前线程等待（释放对象），在此等待，在此开始运行
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.print("1h");
            System.out.print("H");
            System.out.println("哈");
            x = 2;
            this.notifyAll();
        }
    }

    void print2() {
        synchronized (this) {
            while (x != 2) {
                try {
                    this.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.print("2x");
            System.out.print("X");
            System.out.println("下");
            x = 3;
            this.notifyAll();
        }
    }

    void print3() {
        synchronized (this) {
            while (x != 3) {
                try {
                    this.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.print("3y");
            System.out.print("Y");
            System.out.println("有");
            x = 1;
            this.notifyAll();
        }
    }

    public static void main(String[] args) {
        Demo5_notifyAll d = new Demo5_notifyAll();
        new Thread(){
            @Override
            public void run() {
                for (;;)
                d.print1();
            }
        }.start();
        new Thread(){
            @Override
            public void run() {
                for (;;)
                d.print2();
            }
        }.start();
        new Thread(){
            @Override
            public void run() {
                for (;;)
                d.print3();
            }
        }.start();
    }
}
