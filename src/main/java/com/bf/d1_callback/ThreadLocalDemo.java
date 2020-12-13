package com.bf.d1_callback;

/**
 * @author xu rongchao
 * @date 2020/12/6 16:12
 */
public class ThreadLocalDemo {

    public static void main(String[] args) {
        ThreadLocal<Integer> threadLocal = new ThreadLocal<>();

        threadLocal.set(1);

        /**
         * jps -l
         * jstack 8928
         */
        while (true) {
            try {
                System.out.println("1");
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
