package com.xu.day18__Map;

import com.xu.day18__Map.bean.Student;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * 实体类需要重写hashCode和equals方法（和hash有关的都要重写）
 * HashMap只对Key进行hash
 * @see HashMap#toString()
 */
public class Demo4__HashMap_hashCode {

    @Test
    public void test(){
        Map<Student, String> map = new HashMap<>();
        map.put(new Student("xu", 20), "1");
        map.put(new Student("xu", 20), "2");//对比key的hashCode相等，覆盖
        map.put(new Student("hh", 22), "3");
        map.put(new Student("xx", 20), "4");
        map.put(new Student("uu", 20), "5");

        System.out.println(map);
    }
}
