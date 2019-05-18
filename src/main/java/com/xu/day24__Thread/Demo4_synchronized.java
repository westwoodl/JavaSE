package com.xu.day24__Thread;

/**
 * 同步代码块锁
 * synchronized(s){//可以是任意对象，多个同步代码块时，传相同对象（对该对象进行锁定，不同对象起不到同步的作用）
 * {@link #print1()} {@link #print2()}
 * }
 * 同步方法锁:
 *     非静态锁同步方法的锁对象为this{@link #print3()}
 *     静态同步方法的锁对象为该类的字节码对象 Demo.class {@link #print4()}
 *
 *     字节码对象：
 *         每个类被加载之后，系统就会为该类生成一个对应的字节码对象，通过该字
 *         节码对象就可以访问到JVM中的对应的类。在Java中获得Class对象通常有三种方式。
 *         Class<类类型> clz1 = 类名.class;
 *         Class<?> clz2 = Class.forName("java.util.Date");
 *         Class<?> clz3 = str.getClass();
 */
public class Demo4_synchronized {
    int x;

    void print1() {
        synchronized (this) {
            for (int n = 0; n < 100; n++)
                System.out.print("h");
        }
    }

    void print2() {
        synchronized (this) {
            for (int n = 0; n < 100; n++)
                System.out.print("x");
        }
    }

    /**
     * 非静态方法同步锁传入的this对象
     */
    synchronized void print3() {
        for (int n = 0; n < 100; n++)
            System.out.print("x");
    }

    /**
     * 静态方法同步锁传入的的字节码对象
     */
    static synchronized void print4() {
        for (int n = 0; n < 100; n++)
            System.out.print("x");
    }

    static void print5() {
        synchronized (Demo4_synchronized.class) {
            for (int n = 0; n < 100; n++)
                System.out.print("x");
        }
    }

    class MyThread extends Thread {
        @Override
        public void run() {
            print1();
            x = 1;
        }
    }

    public static void main(String[] args) {
        //想要内部类的实例对象，必须创建外部类的实例对象
        Thread m = new Demo4_synchronized().new MyThread();
        Thread t2 = new Thread() {
            @Override
            public void run() {
                new Demo4_synchronized().print2();
            }
        };
        t2.start();
        m.start();
    }
}


