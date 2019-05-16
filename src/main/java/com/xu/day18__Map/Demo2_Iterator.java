package com.xu.day18__Map;

import org.junit.Test;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * Map 没有iterator
 * 双列集合的迭代
 * @see Map#keySet()
 */
public class Demo2_Iterator {

    @Test
    public void test(){
        Map<String, Integer> map = new HashMap<>();
        map.put("1", 1);
        map.put("2", 2);
        map.put("3", 3);
        map.put("4", 4);
        System.out.println(map);

        /**
         * 第一种，转换为set 使用set的迭代器 方法
         */
        Set<String> set = map.keySet();
        Iterator<String> it = set.iterator();
        while (it.hasNext()){
            String key = it.next();
            Integer value = map.get(key);
            System.out.println(key + "==" + value);
        }
        /**
         * 第二种,使用set的迭代器 加 foreach 更好
         */
        for (String key : map.keySet())
            System.out.println(key + "=" + map.get(key));
    }
}
