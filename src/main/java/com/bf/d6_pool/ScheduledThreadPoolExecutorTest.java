package com.bf.d6_pool;

import java.util.concurrent.*;

/**
 * @author xu rongchao
 * @date 2020/7/25 21:36
 */
public class ScheduledThreadPoolExecutorTest {

    public static void main(String[] args) {
        ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = new ScheduledThreadPoolExecutor(
                5, new ThreadFactory() {
            @Override
            public Thread newThread(Runnable r) {
                return new Thread(r);
            }
        });

        scheduledThreadPoolExecutor.schedule(
                ()-> System.out.println("10s后执行")
                , 10, TimeUnit.SECONDS);

        scheduledThreadPoolExecutor.scheduleWithFixedDelay(
                ()-> System.out.println("10s后每隔两秒执行执行")
                , 10, 2, TimeUnit.SECONDS);

        final int[] s = {0};
        scheduledThreadPoolExecutor.scheduleWithFixedDelay(
                ()-> System.err.println(s[0]++)
                , 0, 1, TimeUnit.SECONDS);

        scheduledThreadPoolExecutor.scheduleAtFixedRate(
                ()-> System.out.println("2s后每隔2 + n*3 (n表示次数)执行执行")
                , 2, 3, TimeUnit.SECONDS);


        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        scheduledThreadPoolExecutor.shutdown();
    }
}
