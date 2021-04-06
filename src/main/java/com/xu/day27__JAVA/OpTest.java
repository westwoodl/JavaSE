package com.xu.day27__JAVA;

import org.junit.Test;

import java.util.Optional;

/**
 * @author xu rongchao
 * @date 2021/4/1 22:21
 */
public class OpTest {

    @Test
    public void test() {
        String s = null;
        System.out.println(Optional.ofNullable(s).isPresent());
        System.out.println(Optional.ofNullable(s).filter(e-> false));
        System.out.println(Optional.ofNullable(s).orElse("orElse"));
        System.out.println(Optional.ofNullable(s).isPresent());
    }
}
