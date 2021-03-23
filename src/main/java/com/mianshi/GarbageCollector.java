package com.mianshi;

/**
 * @author xu rongchao
 * @date 2021/1/10 12:41
 */
public class GarbageCollector {

    /**
     * 垃圾回收器：
     * 1. Serial 串行回收器 -XX:+UseSerialGC
     * 2. Parallel 并行回收器 -XX:+UseParallelGC
     * 3. CMS 并发回收 -XX:UseConcMarkSweepGC 并发标记清除
     * 4. G1
     *
     * 垃圾回收算法：
     * 1. 引用计数（不用，有循环引用的风险）
     * 2. 复制拷贝
     * 3. 标记清除
     * 4. 标记整理
     */

    public static void main(String[] args) throws InterruptedException {

        Thread.sleep(Integer.MAX_VALUE);
    }
}
