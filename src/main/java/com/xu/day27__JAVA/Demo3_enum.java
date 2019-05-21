package com.xu.day27__JAVA;

import org.junit.Test;

/**
 * jdk5 enum
 * 枚举类型
 * @see Enum
 */
public class Demo3_enum {

    public static void main(String[] args) {
        Week mon = Week.MON;
        Week2 mon2 = Week2.MON;
        switch (mon) {
            case MON:
                System.out.println("mon");
                break;
            case TUE:
                System.out.println("tue");
                break;
            case WEN:
                System.out.println("wen");
                break;

        }
    }

    /**
     * Enum 的常用方法
     */
    @Test
    public void test(){
        Week2 mon = Week2.MON;
        Week2 tue = Week2.TUE;
        Week2 wen = Week2.WEN;

        System.out.println(mon.ordinal());
        System.out.println(tue.ordinal());
        System.out.println(wen.ordinal());

        System.out.println(mon.compareTo(tue));

        System.out.println(mon.name());
        //super.toString();
        System.out.println(mon.toString());

        Week2 mon3 = Week2.valueOf(Week2.class, "MON");
        System.out.println(mon3);


        Week2[] arr = Week2.values();
        for (Week2 week2 : arr)
            System.out.println(week2);
    }

    enum Week {
        MON, TUE, WEN
    }

    enum Week2 {
        MON("一"), TUE("二"), WEN("三");
        private String name;
        private Week2(String name){
            this.name = name;
        }
        public String getName(){
            return name;
        }

        @Override
        public String toString() {
            return name;
        }
    }
    enum Week3 {
        MON("一") {
            public void show() {
                System.out.println("");
            }
        },
        TUE("二") {
            public void show() {
                System.out.println("");
            }
        },
        WEN("三") {
            @Override
            public void show() {
                System.out.println("");
            }
        };
        String name;

        private Week3(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public abstract void show();
        }
}
