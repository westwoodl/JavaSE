package com.bf.d2_cas;

import org.junit.Test;

import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.LongAccumulator;
import java.util.concurrent.atomic.LongAdder;

/**
 * @author xu rongchao
 * @date 2020-07-13 11:03
 */
public class AtomicAndLongAdderTest {

    /**
     * Atomic类和LongAdder
     */

    @Test
    public void test_long_adder() {
        LongAdder longAdder = new LongAdder();

        longAdder.decrement();
        System.out.println(longAdder.intValue());

        LongAccumulator longAccumulator = new LongAccumulator((a, b) -> {
            long res = 1L;
            for (long i = 0;i<b;i++) {
                res = res * a;
            }
            return res;
        }, 2L);

        longAccumulator.accumulate(3);
        System.out.println(longAccumulator.get());

    }

    @Test
    public void test_atomic() {
        AtomicLong atomicLong = new AtomicLong(0L);
        atomicLong.incrementAndGet();
    }
}
