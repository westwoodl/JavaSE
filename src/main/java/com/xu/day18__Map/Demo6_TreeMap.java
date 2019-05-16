package com.xu.day18__Map;

import com.xu.day18__Map.bean.Student;
import org.junit.Test;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 *
 * key如果为实体类的话，存入TreeMap需要实现Comparable接口或者
 * 在TreeMap的构造方法中传入实现了Comparator的类（多用匿名类）
 *
 * @see java.util.TreeSet
 * @see Comparable
 * @see java.util.Comparator
 */
public class Demo6_TreeMap {
    /**
     * @throws ClassCastException
     */
    @Test
    public void test(){
        Map<Student, String> map = new TreeMap<>(new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                int num = o1.getName().compareTo(o2.getName());
                return num == 0 ? o1.getAge()-o2.getAge() : num;
            }
        });
        map.put(new Student("xu", 20), "1");
        map.put(new Student("xu", 21), "2");//对比key的hashCode相等，覆盖
        map.put(new Student("hh", 22), "3");
        map.put(new Student("xx", 20), "4");
        map.put(new Student("uu", 20), "5");

        System.out.println(map);
    }

    /**
     * 字符出现次数
     */
    @Test public void test2(){
        String str = "aaaaaaabbbbbbbcccccccccddddd";
        char[] chars = str.toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        for (char c : chars)
            map.put(c, map.containsKey(c) ? map.get(c)+1 : 1);

        System.out.println(map);
    }
}
