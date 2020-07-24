package com.bf.d4_aqs;

import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author xu rongchao
 * @date 2020-07-16 16:43
 */
public class ReentrantReadWritelockTest {

    /**
     * 允许多读
     * 写只允许一个，写时不能
     *
     * 使用state的高16位表示读状态，也就是获取到读锁的次数；使用低16位表示获取到写锁
     * 的线程的可重入次数
     * @param args
     */
    public static void main(String[] args) {
        ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();
        ReentrantReadWriteLock.ReadLock readLock = reentrantReadWriteLock.readLock();
        ReentrantReadWriteLock.WriteLock writeLock = reentrantReadWriteLock.writeLock();

        readLock.lock();



    }
}
