package com.xu.day17__Set;

import com.xu.day17__Set.bean.Person;
import org.junit.Test;
import util.O;

import java.util.Comparator;
import java.util.TreeSet;

/**
 * 返回 无重复的 已排序的（泛型的类必须实现Comparable接口）
 *     TreeSet如何存储取决于compareTo方法：返回1，则顺序 返回0 则不add
 * @see TreeSet
 */
public class Demo3_TreeSet {



    @Test
    public void test(){
        TreeSet<Integer> ts = new TreeSet<>();
        ts.add(5);
        ts.add(5);
        ts.add(3);
        ts.add(2);
        System.out.println(ts);

        TreeSet<Person> pts = new TreeSet<>();
        pts.add(new Person("x", 2));
        pts.add(new Person("y", 3));
        pts.add(new Person("z", 4));

        pts.add(new Person("az", 4));
        System.out.println(pts);
    }

    /**
     * Comparator Comparable傻傻分不清
     */
    @Test public void tests(){
        TreeSet<String> ts1 = new TreeSet<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                int num = o1.length()-o2.length();
                return num == 0 ? o1.compareTo(o2) : num;
            }
        });


        TreeSet<Com> ts2 = new TreeSet<>();
        O.o(ts2);
    }
    class Com implements Comparator<String>{

        @Override
        public int compare(String o1, String o2) {
            return 0;
        }
    }
}
