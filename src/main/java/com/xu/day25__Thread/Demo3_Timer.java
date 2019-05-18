package com.xu.day25__Thread;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class Demo3_Timer {

    public static void main(String[] args) {
        Timer t = new Timer();
        t.schedule(new Demo3_Timer().new MyTimeTask(), new Date(new Date().getTime()+5000), 3000);
    }
    class MyTimeTask extends TimerTask {
        @Override
        public void run() {
            System.out.println("TimerTask");
        }
    }
}
