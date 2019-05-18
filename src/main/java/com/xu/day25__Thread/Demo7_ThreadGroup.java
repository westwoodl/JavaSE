package com.xu.day25__Thread;

import org.junit.Test;

/**
 * 将多个线程放在组里
 * @see ThreadGroup
 */
public class Demo7_ThreadGroup {
    class Hh implements Runnable{
        @Override
        public void run() {
            System.out.println(Thread.currentThread().getThreadGroup().getName()+Thread.currentThread().getName()+"11111");
        }
    }

    public static void main(String[] args) {
        Demo7_ThreadGroup d = new Demo7_ThreadGroup();

        ThreadGroup tg = new ThreadGroup("hh");
        Runnable run = d.new Hh();

        Thread t1 = new Thread(tg, run, "h1");
        Thread t2 = new Thread(tg, run, "h2");

        System.out.println(tg);
        System.out.println(tg.getMaxPriority());
        t1.start();
        t2.start();

    }
}
