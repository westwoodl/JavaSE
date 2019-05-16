package com.xu.day18__Map;

import org.junit.Test;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @see java.util.LinkedHashSet
 */
public class Demo5_LinkedHashMap {
    @Test
    public void test(){
        Map<String, Integer> map = new LinkedHashMap<>();
        map.put("1x", 1);
        map.put("2x", 2);
        map.put("3x", 3);
        map.put("4x", 4);
        System.out.println(map);
    }
}
