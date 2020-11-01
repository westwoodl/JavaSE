package com.bf.d5_queue;

import java.util.Random;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

/**
 * @author xu rongchao
 * @date 2020-07-27 18:14
 */
public class DelayQueueTest {
    /**
     * 无界阻塞延迟队列 ，队列中的每个元素都有个过期时间，
     * 当从队列获取元素时，只有过期元素才会出队列。队列头元素是最快要过期的元素。
     * 内部数据结构为大顶堆，使用compareTo构建大顶堆
     *
     * 当getDelay() == 0时出队
     * @param args
     */
    public static void main(String[] args) throws InterruptedException {
        DelayQueue<Delayed> delayQueue = new DelayQueue<>();
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            delayQueue.offer(new DelQueueObj(new String("sd" + i), random.nextInt(10000) + 1000));
        }
        for (; ; ) {
            Delayed delayed = null;
            while ((delayed = delayQueue.poll()) != null) {
                System.out.println(delayed);
            }
        }
    }

    static class DelQueueObj implements Delayed {
        private Object data;
        private long expire;
        private long delay;

        public DelQueueObj(Object data, long delay) {
            this.data = data;
            this.expire = delay + System.currentTimeMillis();
            this.delay = delay;
        }

        /**
         * 返回剩余时间
         *
         * @param unit
         * @return
         */
        @Override
        public long getDelay(TimeUnit unit) {
            return unit.convert(this.expire - System.currentTimeMillis(), TimeUnit.MILLISECONDS);
        }

        @Override
        public int compareTo(Delayed o) {
            return (int) (this.getDelay(TimeUnit.MILLISECONDS) - o.getDelay(TimeUnit.MILLISECONDS));
        }

        @Override
        public String toString() {
            return "DelQueueObj{" +
                    "data=" + data +
                    ", expire=" + expire +
                    ", delay=" + delay +
                    '}';
        }
    }
}
