package com.bf.d7_高级并发;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author xu rongchao
 * @date 2020-08-05 10:47
 */
public class CountDownLatchTest {
    /**
     * 内部的计数器减
     */
    private static volatile CountDownLatch countDownLatch = new CountDownLatch(2);

    /**
     * 主线程等待子线程执行完成后进行汇总
     * old：使用join (一般项目都不直接操作线程，使用线程池，提供Runnable接口实现，这样就无法使用join了)
     * new：使用CountDownLatch更加优雅
     */
    public static void main(String[] args) throws InterruptedException {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(5, 100, 10, TimeUnit.SECONDS, new ArrayBlockingQueue<Runnable>(100), new ThreadFactory() {
            @Override
            public Thread newThread(Runnable r) {
                return new Thread(r);
            }
        });
//        threadPoolExecutor.execute();
//        threadPoolExecutor.submit();
        myUse();
    }

    private static AtomicInteger atomicInteger = new AtomicInteger(0);

    public static void myUse() throws InterruptedException {

        SuccessCheckSupport successCheckSupport = new SuccessCheckSupport(2);
        Thread thread1 = new Thread(() -> {
            try {
                System.out.println(Thread.currentThread());
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                successCheckSupport.countDown();
            }
        });

        Thread thread2 = new Thread(() -> {
            try {
                System.out.println(Thread.currentThread());
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                successCheckSupport.countDown();
            }
        });

        thread1.start();
        thread2.start();
        successCheckSupport.await();
        System.out.println("main");
    }

    static class SuccessCheckSupport {
        private AtomicInteger atomicInteger;

        public SuccessCheckSupport(int count) {
            atomicInteger = new AtomicInteger(count);
        }

        public void countDown() {
            atomicInteger.decrementAndGet();
        }

        public void await(long awaitTime, TimeUnit unit) throws InterruptedException {
            for (;;) {
                Thread.sleep(unit.toMillis(awaitTime));
                if (atomicInteger.get() == 0) {
                    break;
                }
            }
        }

        public void await() throws InterruptedException {
            await(1000, TimeUnit.MILLISECONDS);
        }

    }

    public static void lowUse() throws InterruptedException {
        Thread thread1 = new Thread(() -> {
            try {
                System.out.println(Thread.currentThread());
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                countDownLatch.countDown();
            }
        });

        Thread thread2 = new Thread(() -> {
            try {
                System.out.println(Thread.currentThread());
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                countDownLatch.countDown();
            }
        });

        thread1.start();
        thread2.start();

        countDownLatch.await();
        System.out.println("main");
    }
}
