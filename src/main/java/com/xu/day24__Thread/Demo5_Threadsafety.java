package com.xu.day24__Thread;

import java.util.Collection;

/**
 * 多线程对同一数据进行操作
 *
 *     以往线程安全的类：
 * @see java.util.Vector
 * @see StringBuffer
 * 将集合类变为线程安全的
 * @see java.util.Collections#synchronizedCollection(Collection)
 */
public class Demo5_Threadsafety {
    public static void main(String[] args) {
        Demo5_Threadsafety d5 = new Demo5_Threadsafety();

        new Ticket().start();
        new Ticket().start();
        new Ticket().start();
        new Ticket().start();
        new Ticket().start();
    }

    static class Ticket extends Thread {
        private static int ticketOount = 1000;
        @Override
        public void run() {
            for(;;){
                synchronized(Ticket.class){
                    if (ticketOount==0)break;
                    yield();
                    System.out.println(getName() + ":" + ticketOount-- + "张");
                }
            }
        }
    }



}
