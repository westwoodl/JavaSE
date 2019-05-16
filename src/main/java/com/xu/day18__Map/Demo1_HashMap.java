package com.xu.day18__Map;

import org.junit.Test;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * https://images2015.cnblogs.com/blog/1010726/201706/1010726-20170621004734695-988542448.png
 * Collection下的Set下的HashSet依赖 Map下的HashMap（单列集合依赖于双列集合）有变无简单
 * @see HashSet()
 * @see HashMap
 */
public class Demo1_HashMap {

    static{

    }
    @Test
    public void test(){
        //查看底层源码便知晓
        new HashSet().add("s");

        Map<String, Integer> map = new HashMap<>();
        System.out.println(map.put("1", 1));
        System.out.println(map.put("2", 2));
        System.out.println(map.put("3", 3));
        System.out.println(map.put("4", 4));
        System.out.println(map.put("4", 5));//返回被覆盖的值
        System.out.println(map);

        Collection<Integer> c = map.values();
        System.out.println(c);

    }

}
