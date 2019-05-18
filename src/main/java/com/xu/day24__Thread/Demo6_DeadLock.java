package com.xu.day24__Thread;

/**
 * 死锁
 *      synchronized没有获取到对象会一直等待
 *      成功理解synchronized后面的对象的意思：
 *          以下同步锁需要该对象的资源，其他需要该对象的资源的都需要在synchronized代码执行玩后执行
 */
public class Demo6_DeadLock {

    private static String s1 = "s1";
    private static String s2 = "s2";

    public static void main(String[] args) {
        new Thread(){
            @Override
            public void run() {
                while (true) {
                    synchronized (s1) {
                        System.out.println(getName()+"get s1");
                        synchronized(s2){
                            System.out.println(getName()+"get s2");
                        }
                    }
                }
            }
        }.start();
        new Thread(){
            @Override
            public void run() {
                while (true) {
                    synchronized (s2) {
                        System.out.println(getName()+"get s2");
                        synchronized(s1){
                            System.out.println(getName()+"get s1");
                        }
                    }
                }
            }
        }.start();

        new Thread(){
            @Override
            public void run() {
                while (true) {
                    synchronized (s2) {
                        System.out.println(getName()+"get s2");
                        synchronized(s1){
                            System.out.println(getName()+"get s1");
                        }
                    }
                }
            }
        }.start();
    }

}
