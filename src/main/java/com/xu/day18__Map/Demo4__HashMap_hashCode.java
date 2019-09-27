package com.xu.day18__Map;

import com.xu.day18__Map.bean.Student;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * 实体类需要重写hashCode和equals方法（和hash有关的都要重写）
 * HashMap只对Key进行hash
 * @see HashMap#toString()
 *
 * ------------------ HashMap原理 -------------------------
 * Hash表是一个数组+链表的结构，这种结构能够保证在遍历与增删的
 * 过程中，即使发生hash冲突，也能保证数据的正常存储
 *
 * 在发生hash冲突时，才调用equals方法判断是否是同一个元素，不是
 * 同一个元素则添加至当前地址的链表之后。jdk1.8之后，链表长度大
 * 于8时，该节点上的数据就不再以链表进行存储，而是转成了一个红黑树。
 */
public class Demo4__HashMap_hashCode {

    @Test
    public void test(){
        HashMap<Student, String> map = new HashMap<>();
        map.put(new Student("xu", 20), "1");
        map.put(new Student("xu", 20), "2");//对比key的hashCode相等，覆盖
        map.put(new Student("hh", 22), "3");
        map.put(new Student("xx", 20), "4");
        map.put(new Student("uu", 20), "5");

        String s =  map.get(new Student("xx", 20));
        System.out.println(s);
        System.out.println(map);
    }
}
