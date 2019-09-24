package com.xu.day25__Thread;

public class Demo10_volatile {

    /**
     *    volatile
     *    volatile修饰的变量不允许线程内部cache缓存和重排序，
     *    线程读取数据的时候直接读写内存，同时volatile不会对变量加锁，
     */
    private static volatile int x = 1;

    private static int y = 2;

    public static void main(String[] args) throws InterruptedException {
        /**
         * ThreadRead出现死循环，读取不到
         * 内存不可见的原因
         * 1.线程在运行的过程中会把主内存的数据拷贝一份到线程内部cache中，
         * 也就是working memory。这个时候多个线程访问同一个变量，其实就是
         * 访问自己的内部cache。
         * 2.除了cache的原因，重排序后的指令在多线程执行时也有可能导致
         * 内存不可见，由于指令顺序的调整，线程Read读取某个变量的时候线程Modify可能
         * 还没有进行写入操作呢，虽然代码顺序上写操作是在前面的
         */
        new ThreadRead().start();

        Thread.sleep(1000);

        new ThreadModify().start();


    }

    /**
     * 修改主存中的变量
     */
    static class ThreadModify extends Thread {
        @Override
        public void run() {
            x = 2;
        }
    }

    /**
     * 从主存中加载x到自己的内部缓存cache（cpu的高速缓冲器）中，判断的一直是内部缓存的值，
     * 即使主存的值改变了，cache的值没有改变，所以没有改变。
     * * 每次循环睡一段时间，会重新从主存中加载到cache
     */
    static class ThreadRead extends Thread {
        @Override
        public void run() {
            while (true)
                if (x == 2) {
                    System.out.println(x);
                    break;
                }
        }
    }
}
