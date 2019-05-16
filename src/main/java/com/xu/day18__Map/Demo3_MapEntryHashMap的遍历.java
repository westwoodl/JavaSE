package com.xu.day18__Map;

import com.xu.day16__List.Demo3_Generic;
import org.junit.Test;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * 使用Set<Map.Entry<K, V>> entrySet()迭代
 *     通过entrySet()将HashMap<K, V>转换成一个<Map.Entry<K, V>的set集合
 * 内部接口：
 *     Map.Entry(Entry is a inner interface where in Map )
 *
 * @see Map.Entry
 * @see HashMap Node
 * @see HashMap#entrySet()
 */
public class Demo3_MapEntryHashMap的遍历 {
    interface InnerInt{void show();}

    @Test public void test2(){
        Map<String, Integer> map = new HashMap<>();
        map.put("1k", 1);
        map.put("2k", 2);
        map.put("3k", 3);
        map.put("4k", 4);
        /**
         * 使用Set<Map.Entry<K, V>> entrySet()迭代
         */


        for (Map.Entry<String, Integer> e : map.entrySet())
            System.out.println(e.getKey() + "=" + e.getValue()+ "=");
        //推荐上面这种简单粗暴的写法
        Set<Map.Entry<String, Integer>> entrySet = map.entrySet();
        Iterator<Map.Entry<String, Integer>> it = entrySet.iterator();
        while (it.hasNext()){
            Map.Entry<String, Integer> e = it.next();
            System.out.println(e.getKey() + "=" + e.getValue());
        }
    }
    @Test
    public void test(){
        InnerInt i = new DemoImplInnerInterface();
        i.show();
        Int.InnerInt i2 = new DemoImplInnerInterface();
        i2.show();
    }
}

/**
 * Map.Entry形同下(就是个内部接口)
 */
interface Int {
    interface InnerInt{
        void show();
    }
}
class DemoImplInnerInterface implements Demo3_MapEntryHashMap的遍历.InnerInt, Int, Int.InnerInt{
    final static class A{}

    @Override
    public void show() {
        System.out.println("看，我们重写了类里的内部接口");
    }
}
