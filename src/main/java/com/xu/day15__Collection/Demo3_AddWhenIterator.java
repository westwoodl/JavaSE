package com.xu.day15__Collection;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

/**
 * 使用ListIterator解决遍历时不能添加的问题
 */
public class Demo3_AddWhenIterator {

    @Test
    public void haha(){

        List list = new ArrayList();
        list.add("a");
        list.add("b");
        list.add("word");
        list.add("c");

        /*
        Iterator it = list.iterator();
        while (it.hasNext())
            if(((String)it.next()).equals("word"))
                list.add("javaee");//迭代时添加,抛出java.util.ConcurrentModificationException

        System.out.println(list);
         */

        ListIterator lit = list.listIterator();
        while (lit.hasNext())
            if(((String)lit.next()).equals("word"))
                lit.add("javaee");//迭代时添加,抛出java.util.ConcurrentModificationException

        System.out.println(list);
    }
}
