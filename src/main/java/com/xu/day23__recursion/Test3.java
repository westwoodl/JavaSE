package com.xu.day23__recursion;

import org.junit.Test;

import java.math.BigInteger;

/**
 * 斐波那契{@link #fibonacci}
 * 阶乘{@link #factorial}
 */
public class Test3 {

    /**
     * @param x
     * @return 返回第x个fibonacci数列
     */
    int fibonacci(int x) {
        return x <= 2 ? 1 : fibonacci(x - 1) + fibonacci(x - 2);
    }

    @Test
    public void test2() {
        for (int x = 1; x < 50; x++)
            System.out.println(fibonacci(x));
    }

    /**
     * @param x
     * @return x!
     */
    public BigInteger factorial(int x) {
        return x <= 0 ? new BigInteger(1 + "") : factorial(x - 1).multiply(new BigInteger(x + ""));
    }

    @Test
    public void testf() {
        System.out.println(factorial(100));
    }
}
