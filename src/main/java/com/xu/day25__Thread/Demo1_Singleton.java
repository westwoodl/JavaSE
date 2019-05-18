package com.xu.day25__Thread;

import org.junit.Test;

/**
 * 单例模式
 */
public class Demo1_Singleton {
    @Test
    public void test(){
        SlackerMode s1 = SlackerMode.getInstance();
        SlackerMode s2 = SlackerMode.getInstance();
        System.out.println(s1);
        System.out.println(s2);
        System.out.println(s1 == s2);
    }

    public static void main(String[] args) {
        new SingletonAsynchronous().start();
        new SingletonAsynchronous().start();
        new SingletonAsynchronous().start();
        new SingletonAsynchronous().start();
        new SingletonAsynchronous().start();
        new SingletonAsynchronous().start();
        new SingletonAsynchronous().start();
        new SingletonAsynchronous().start();
        new SingletonAsynchronous().start();
        new SingletonAsynchronous().start();
    }
}

/**
 * 饿汉模式
 */
class StarvingModel {
    private final static StarvingModel s = new StarvingModel();

    private StarvingModel(){}

    public static StarvingModel getInstance(){
        return s;
    }
}

/**
 * 懒汉模式
 */
class SlackerMode{
    private static SlackerMode s = null;

    private SlackerMode(){}

    /**
     * @return 存在线程安全问题
     */
    public static SlackerMode getInstanceThreadFree() {
        return s == null ? s = new SlackerMode() : s;
    }

    /**
     * 双重检验锁
     * @return
     */
    public static SlackerMode getInstance() {
        if (s == null)
            synchronized (SlackerMode.class) {
                if (s == null)
                    s = new SlackerMode();
            }
        return s;
    }
}

/**
 * 静态内部类实现懒汉模式
 */
class InnerClassSinglton {
    private InnerClassSinglton(){}

    private static class InnerClass {
        private static InnerClassSinglton i = new InnerClassSinglton();
    }

    public static InnerClassSinglton getInstance(){
        return InnerClass.i;
    }
}
class SingletonAsynchronous extends Thread{
    @Override
    public void run() {
        System.out.println(InnerClassSinglton.getInstance());
    }
}