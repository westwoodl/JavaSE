package com.bf.d4_aqs;

import org.junit.Test;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author xu rongchao
 * @date 2020-07-13 16:04
 */
public class AQSTest {

    /**
     * AQS (AbstractQueuedSynchronizer 抽象同步队列) {@link AbstractQueuedSynchronizer}
     * 基于CLH双向链表队列，用volatile修饰共享变量state，线程通过CAS去改变状态符，成功则获取锁成功，失败则进入等待队列，等待被唤醒。
     *
     * 1.对于ReentrantLock来说，state可以用来表示当前线程获取锁的可重入次数。
     * 2.对于读写锁 ReentrantReadWriteLock来说 state 16位表示读状态，也就是获
     * 取该读锁的次数，低 16 位表示获取到写锁的线程的可重入次数。
     * 3.对于semaphore来说，state用来表示当前可用信号的个数。
     * 4.对于 CountDownlatch 来说，state 来表示计数器当前的值
     *
     * 自旋锁、互斥锁、读锁写锁、条件产量、信号量、栅栏都是AQS的衍生物
     */

    @Test
    public void aqs_test() {

        ReentrantLock lock = new ReentrantLock();
        Condition condition = lock.newCondition();

        lock.lock();
        try {
            condition.await();
            System.out.println(Integer.MIN_VALUE - 1);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(Integer.MAX_VALUE + 1);

        } finally {
            lock.unlock();
            System.out.println(1);
        }
    }

    @Test
    public void reentrant_read_write_lock() {
        ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();

        ReentrantReadWriteLock.ReadLock readLock = reentrantReadWriteLock.readLock();
        ReentrantReadWriteLock.WriteLock writeLock = reentrantReadWriteLock.writeLock();

        readLock.lock();


    }


    class ReadWriteSafeArrayList<T> {

        private ArrayList<T> list;
        ReentrantReadWriteLock reentrantReadWriteLock;
        private ReentrantReadWriteLock.ReadLock readLock;
        private ReentrantReadWriteLock.WriteLock writeLock;

        ReadWriteSafeArrayList() {
        }

        private void init() {
            list = new ArrayList<>();
            reentrantReadWriteLock = new ReentrantReadWriteLock();
            readLock = reentrantReadWriteLock.readLock();
            writeLock = reentrantReadWriteLock.writeLock();
        }

        public void add(T t) {
            if (list == null) {
                init();
            }
            writeLock.lock();
            list.add(t);
            writeLock.unlock();
        }

        public T get(int index) {
            if (index < 0) {
                throw new IllegalArgumentException();
            }
            if (list == null) {
                return null;
            }
            T t = null;
            readLock.lock();
            try {
                t = list.get(index);
            } catch (Exception e) {
                throw e;
            } finally {
                readLock.unlock();
            }
            return t;
        }

        public int size() {
            return list.size();
        }
    }

    @Test
    public void test_thr() {
        try {
            throw new RuntimeException();
        } catch (Exception e) {
            System.out.println(2);
            throw e;
        } finally {
            System.out.println(1);
        }
    }

    /**
     *  人生如梦 一樽还酹江月
     */
    @Test
    public void test_stream() {
        // 为null也不会发生NPE
        List<Integer> list = Arrays.asList(1, 23, 3);
        Optional<List<Integer>> optional = Optional.ofNullable(list);
        optional.orElse(new ArrayList<>())
                .stream()
                .map(Object::toString)
                .collect(Collectors.toList())
                .forEach(System.out::println);
    }


}
