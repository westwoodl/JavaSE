package com.mianshi;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.TreeMap;
import java.util.concurrent.atomic.AtomicStampedReference;

/**
 * @author xu rongchao
 * @date 2020-11-26 18:26
 */
public class AtomicDemo {


    /**
     * cas：
     *     1. 原子指令
     *
     * @param args
     */
    public static void main(String[] args) {
        AtomicStampedReference<User> asr = new AtomicStampedReference<>(new User(1, "1"), 1);

        TreeMap<String, String> s = new TreeMap<>();
        s.put("s5", "5");
        s.put("s1", "1");
        s.put("s3", "3");
        s.put("s2", "2");
        s.put("s4", "4");


        s.forEach((k, v) -> {
            System.out.println(k + v);
        });

    }

    @Data
    @AllArgsConstructor
    static class User {
        Integer a;
        String b;
    }
}
