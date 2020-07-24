package com.bf.d4_aqs;

import java.util.concurrent.locks.StampedLock;

/**
 * @author xu rongchao
 * @date 2020-07-21 19:51
 */
public class StampedLockTest {
    /**
     * StampedLock 提供的三种读写模式的锁分别如下： （不可重入锁）
     * <p>
     * 1.写锁 writeLock 是一个排它锁或者独占锁，某时只有一个线程可以获取该
     * 锁， 当一个线程获取该锁后，其他请求读锁和写锁的线程必须等待，这类似于
     * ReentrantReadWriteLock 的写锁（不同的是这里的写锁是不可重入锁） 当目前没有
     * 线程持有读锁或者写锁 才可以获取到该锁 请求该锁成功后会返回一个 stamp
     * 量用来表示该锁的版本，当释放该锁时需要调用 unlockWrite 方法并传递获取锁时
     * stamp 参数 。并且它提供了 非阻塞 tryWriteLock 方法
     * <p>
     * 2.悲观读锁 readLock 是一个共享锁，在没有线程获取独占写锁的情况下，多个线程
     * 可以同时获取该锁。如果己经有线程持有写锁，则其他线程请求获取该读锁会被阻
     * 塞，这类似于 ReentrantReadWriteLock 的读锁 （不同的是这里的读锁是不可重入锁〉。
     * 这里说的悲观是指在具体操作数据前其会悲观地认为其他线程可能要对自己操作的
     * 数据进行修改，所以需要先对数据加锁，这是在读少写多的情况下的一种考虑。请
     * 求该锁成功后会返回 stamp 用来表示该锁的版本，当释放该锁时需要调用
     * unlockRead 方法并传递 stamp 参数。并且它提供了非阻塞的 tryReadLock 方法
     * <p>
     * 3.乐观读锁tryOptimisticRead 它是相对于悲观锁来说的，在操作数据前并没有通过
     * CAS 设置锁的状态，仅仅通过位运算测试。如果当前没有线程持有写锁，则 简单
     * 地返回 个非 sta mp 版本信息 获取该 tamp 后在具体操作数据前还需要调用
     * validate 方法验证 mp 是否己经不可用，也就是看当调用 trγOptimisticRead 返回
     * stamp 后到 当前时间期间是否有其 线程持有了写锁，如果是则 va lidate 会返回
     * 否则就可以使用该 tamp 版本的锁对数据进行操作 由于 tr OptimisticRead 并没有
     * 使用 CAS 设置锁状态，所以不需要显式地释放该锁 该锁的 个特点是适用于
     * 多写少的场 因为获取读锁只是使用位操作进行检验，不涉及 AS 操作，所以
     * 效率会高很多，但是同时由于没有使用真正的锁，在保证数据 致性上需要复制
     * 份要操作的变 到方法钱，并且在操作数据时可能其他写线程己经修改了数据，而
     * 操作的是方法战里面的数据，也就是 个快照，所以最多返回 的不是最新的数
     * 据，但是一致性还是得到保障的
     * StampedLock 支持这三种锁在
     *
     * @param args
     */

    private final StampedLock stampedLock = new StampedLock();

    public static void main(String[] args) {

    }

    /**
     * StampedLock 提供的读写锁与 ReentrantReadWriteLock 类似，只前者者提供的是不
     * 重入锁。但是前者通过提供乐观读锁在多线程多读的 情况下提供了更好的的性能 这是因为
     * 获取乐观读锁时不需要进行 CAS 操作设置锁的状态，而只是简单 测试 态。
     */


    int x, y;

    /**
     * 使用乐观锁，同时也避免了写锁入侵
     * @return
     */
    int add() {
        // 尝试获取乐观读锁
        long stamp = stampedLock.tryOptimisticRead();
        // 变量复制入方法栈内
        int xx = x, yy = y;
        // 读取时有其他写锁抢占了
        if (!stampedLock.validate(stamp)) {
            stamp = stampedLock.readLock();
            try {
                xx = x;
                yy =y;
            } finally {
                stampedLock.unlockWrite(stamp);
            }
        }
        return xx+yy;
    }
}
