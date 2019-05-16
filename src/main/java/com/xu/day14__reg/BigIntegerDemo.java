package com.xu.day14__reg;

import org.junit.Test;

import java.math.BigInteger;

/**
 * 大整数运算
 */
public class BigIntegerDemo {

    @Test
    public void testInteger(){

        //long l = 123456789098765432121321321L;
        String str = "1234567890987654321213212312";
        BigInteger bi = new BigInteger(str);
        Integer i;

        System.out.println(bi.multiply(bi));
    }
}
