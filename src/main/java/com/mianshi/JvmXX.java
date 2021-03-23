package com.mianshi;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xu rongchao
 * @date 2020/12/13 17:29
 */
public class JvmXX {


    /**
     * 两个经典X参数
     * -Xms 等价于 -XX:InitialHeapSize 初始大小内存 1/64
     * -Xmx 等价于 -XX:MaxHeapSize 最大分配内存1/4
     * -Xss -XX:ThreadStackSize 每个线程的栈空间大小
     * -Xmn
     *
     * XX参数
     * -XX:+PrintGCDetails 是否打印gc详情
     * -XX:+UseSerialGC 是否使用串行垃圾回收
     *
     * -XX:MetaspaceSize=128m
     *
     * 查看类运行参数
     * java -flags info
     * java -XX:+PrintFlags
     *
     * 常用参数
     * -Xms
     *
     * @param args
     */
    public static void main(String[] args) throws InterruptedException {
        System.out.println(Runtime.getRuntime().totalMemory()/1024/1024);
        System.out.println(Runtime.getRuntime().maxMemory()/1024/1024);

        List<String> list = new ArrayList<>();

        for (int i = 0;;i++) {
            if (i%1000000 == 0) {

                System.err.println("gc-sleep");
                Thread.sleep(1000);
                list.clear();
            }
            list.add(String.valueOf(i));
        }
    }
}
