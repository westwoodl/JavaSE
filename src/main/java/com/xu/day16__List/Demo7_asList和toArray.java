package com.xu.day16__List;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Demo7_asList和toArray {
    /**
     * 数组转集合
     */
    @Test
    public void test(){
        List<int[]> intList = Arrays.asList(new int[]{1,2,3,4});
        for (int[] i:intList)//只存了一个数组
            for (int o:i)
                System.out.println(o);
        /**
         * 怪
         */
        List<Integer> integerList = Arrays.asList(new Integer[]{1,2,3,4});
        for (int i:integerList)
            System.out.println(i);
    }
    /**
     * 集合转数组
     */
    @Test public void test1(){
        List<Integer> list = new ArrayList<>();
        list.add(2);list.add(3);list.add(4);list.add(5);

        Integer[] arr = list.toArray(new Integer[10]);
        for (Integer a : arr)
            System.out.println(a);
    }

    /**
     * 最后：集合嵌套集合
     */
    List<List<List<List<List>>>> lllll;
}
