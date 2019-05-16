package com.xu.day13__SB_Arrays;

import org.junit.Test;

public class IntegerDemo {

    @Test
    public void execute(){
        Integer a = 127;
        Integer b = 127;
        System.out.println(a==b);
        System.out.println(a.equals(b));

        a = 128;
        b = 128;
        System.out.println(a==b);
        System.out.println(a.equals(b));
        /**
         * -128 ~ 127是byte的取值范围，若在此范围内，自动装箱不会新创建对象，而是从常量池获取，否则创建新对象
         *
         * public static Integer valueOf(int i) {
         *         if (i >= IntegerCache.low && i <= IntegerCache.high)
         *             return IntegerCache.cache[i + (-IntegerCache.low)];
         *         return new Integer(i);
         *     }
         */
    }
}
