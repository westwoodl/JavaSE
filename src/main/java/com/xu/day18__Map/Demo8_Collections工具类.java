package com.xu.day18__Map;

import org.junit.Test;

import java.util.*;

/**
 * @see java.util.Collections
 */
public class Demo8_Collections工具类 {

    @Test
    public void test(){

        List<String> list = new ArrayList<>();
        list.add("b");
        list.add("g");
        list.add("g");
        list.add("i");
        list.add("a");

        //list.sort(null);
        Collections.sort(list);//就是sort
        System.out.println(list);

        System.out.println(Collections.binarySearch(list, "c"));

        System.out.println(Collections.max(list));

        Collections.reverse(list);
        System.out.println(list);

        Collections.shuffle(list);//洗牌
        System.out.println(list);
    }

    @Test public void test1(){
        TestGenric<?> t = new TestGenric<>();
        t.show(t);

    }
}

class TestGenric<T> {
    void show(TestGenric<?> t){
        System.out.println(t);
    }

}