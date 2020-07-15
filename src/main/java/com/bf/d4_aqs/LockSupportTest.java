package com.bf.d4_aqs;

import java.util.concurrent.locks.LockSupport;

/**
 * @author xu rongchao
 * @date 2020-07-15 15:27
 */
public class LockSupportTest {
    // todo

    public static void main(String[] args) {
        System.out.println(1);
        LockSupport.park();
        System.out.println(2);
        LockSupport.unpark(Thread.currentThread());
        System.out.println(3);
        // 调用unpark后在调用park会直接返回
    }
}
