package com.xu.day16__List;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * 遍历数组和Collection,底层使用迭代器实现
 */
public class Demo4_Foreach和遍历时删除 {

    @Test
    public void test(){
        for(int i:new int[]{1,2,3}){
            System.out.println(i);
        }
    }
    List<Integer> list = new ArrayList<>();
    public Demo4_Foreach和遍历时删除(){
        list.add(1);list.add(2);list.add(3);list.add(4);list.add(4);list.add(5);
    }
    /**
     * 遍历时删除：
     */
    @Test public void test1(){
        for (int i = 0; i < list.size(); i++) {
            if(list.get(i)==4)
                list.remove(i--);//关键所在：size会改变
        }
        System.out.println(list);
    }

    /**
     * 迭代器遍历删除
     */
    @Test public void test2(){
        /**
         * listIterator比iterator多了add()增加 set()修改 nextIndex()下个索引 previousIndex()前个索引
         */
        for (Iterator<Integer> it = list.iterator();it.hasNext();) {
            if(it.next()==4)
                it.remove();
                //list.remove(i--);并发修改异常
        }
        System.out.println(list);
    }
}
