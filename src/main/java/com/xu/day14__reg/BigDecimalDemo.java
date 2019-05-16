package com.xu.day14__reg;

import org.junit.Test;

import java.math.BigDecimal;

/**
 * 小数运算
 */
public class BigDecimalDemo {

    @Test
    public void exe(){
        System.out.println(2.0 - 1.1);

        BigDecimal bd1 = new BigDecimal(2.0);
        BigDecimal bd2 = new BigDecimal(1.1);
        System.out.println(bd1.subtract(bd2));

        BigDecimal bd3 = new BigDecimal("2.0");
        BigDecimal bd4 = new BigDecimal("1.1");
        System.out.println(bd3.subtract(bd4));


        BigDecimal bd5 = BigDecimal.valueOf(2.0);
        BigDecimal bd6 = BigDecimal.valueOf(1.1);
        System.out.println(bd5.subtract(bd6));

        BigDecimal bd7 = new BigDecimal(10);
        BigDecimal bd8 = new BigDecimal(3);
        /**
         * @throw ArithmeticException
         */
        System.out.println(bd7.divide(bd8, 10, BigDecimal.ROUND_DOWN));
    }
}
