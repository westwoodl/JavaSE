package com.bf.d4_aqs;

import org.junit.Test;

import java.util.concurrent.locks.LockSupport;

/**
 * @author xu rongchao
 * @date 2020-07-13 15:29
 */
public class LockTest {



    @Test
    public void test_lock_support() throws InterruptedException {

        Thread t1 = new Thread(() -> {
            System.out.println ("child thread begin park");
            LockSupport.park();
            System.out.println ("child thread begin unpark");

        });
        t1.start();
        Thread.sleep(1000);
        System.out.println ("main thread begin park");
//        LockSupport.unpark(t1) ;
        Thread.sleep(1000);
        t1.interrupt();

    }
}
