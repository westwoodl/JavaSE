package com.bf.d1_callback;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author xu rongchao
 * @date 2020-07-11 15:29
 */
public class CallBackTest {

    /**
     * 。前两种方式都没办法拿到任务
     * 的返回结果，但是 FutureTask 方式可以
     */
    static  class CallerTask implements Callable<Object> {

        @Override
        public Object call() throws Exception {
            System.out.println("call");
            Thread.sleep(3000);
            System.out.println("call2");
            throw new IllegalArgumentException();
        }
    }

    public final static ThreadLocal THREAD_LOCAL = new ThreadLocal();
    /**
     *     让子线程可 以访问在父线程中设置的本地变量
     */
    public final static InheritableThreadLocal INHERITABLE_THREAD_LOCAL = new InheritableThreadLocal();

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FutureTask<Object> futureTask = new FutureTask<>(new CallerTask());

        new Thread(futureTask).start();

        // System.out.println(futureTask.get());
        new Thread(()->{
            try {
                Thread.sleep(4000);
                System.out.println("开始获取"+futureTask.get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                System.out.println(e);
            }
        }).start();
        System.out.println(2);

        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {

            }
        });
        // 如果当
        //前进程中不存在用户线程，但是还存在正在执行任务的守护线程，则JVM不等守护线程
        //运行完毕就会结束JVM进程
        t.setDaemon(true);


    }

}
