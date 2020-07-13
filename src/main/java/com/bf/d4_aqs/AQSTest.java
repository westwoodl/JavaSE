package com.bf.d4_aqs;

import org.junit.Test;

import java.util.concurrent.locks.AbstractQueuedSynchronizer;

/**
 * @author xu rongchao
 * @date 2020-07-13 16:04
 */
public class AQSTest {

    /**
     * 自旋锁、互斥锁、读锁写锁、条件产量、信号量、栅栏都是AQS的衍生物
     * AQS就是基于CLH队列，用volatile修饰共享变量state，线程通过CAS去改变状态符，成功则获取锁成功，失败则进入等待队列，等待被唤醒。
     */

    @Test
    public void aqs_test() {

        AbstractQueuedSynchronizer abstractQueuedSynchronizer = new AbstractQueuedSynchronizer() {
            @Override
            protected boolean tryAcquire(int arg) {
                return super.tryAcquire(arg);
            }

            @Override
            protected boolean tryRelease(int arg) {
                return super.tryRelease(arg);
            }

            @Override
            protected int tryAcquireShared(int arg) {
                return super.tryAcquireShared(arg);
            }

            @Override
            protected boolean tryReleaseShared(int arg) {
                return super.tryReleaseShared(arg);
            }

            @Override
            protected boolean isHeldExclusively() {
                return super.isHeldExclusively();
            }
        };
    }

}
