package com.xu.day15__Collection;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class Demo2_List {
    @Test
    public void hah(){
        List list = new ArrayList();
        list.add(111);
        list.add("a");
        list.add("a");
        list.add(1, "e");
        System.out.println(list);
        System.out.println(list.get(1));
        list.remove(new Integer(111));//删除时不会自动装箱
        System.out.println(list);

    }
}
