package com.xu.day24__Thread;

/**
 * 多线程对同一数据进行操作
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
