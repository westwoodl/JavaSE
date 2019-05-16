package com.xu.day15__Collection;

import com.xu.day15__Collection.bean.Student;
import org.junit.Test;

import java.util.*;

/**
 * https://github.com
 * https://images2015.cnblogs.com/blog/1010726/201706/1010726-20170621004734695-988542448.png
 * https://images2015.cnblogs.com/blog/1010726/201706/1010726-20170621004756882-1379253225.gif
 *
 * 数组的弊端：长度固定
 * 集合的弊端：内存占用大 优点：长度可变
 *
 *                 Collection
 *
 *           List                  set
 *
 * ArrayList  LinkedList     HashSet   TreeSet
 *  数组          链表         hash       tree
 *
 *
 */
public class Demo1_Collection {
    Collection<String> collection;
    Collections collections;

    @Test
    public void test(){
        Collection c = new ArrayList();
        System.out.println(c.add(new Student("xu")));//对于list 永远返回true
        c.add(true);
        c.add("hahaha");
        System.out.println(c);

        c.remove(true);c.remove(true);
        System.out.println(c);

        System.out.println(Arrays.toString(c.toArray()));

        System.out.println('-');
        Iterator ite = c.iterator();

        while (ite.hasNext()){
            System.out.println(ite.next());
            ite.remove();//每次remove，都要先next()
        }
        System.out.println(c);
    }
}

/**
 * 迭代器模式: Iterator Pattern
 *     每一个集合结构都不一样的，存取都不一样
 */
class IterableAndIterator implements Iterable{

    public Iterator iterator() {
        return new IteratorDemo();
    }

    class IteratorDemo<E> implements Iterator<E>{

        public boolean hasNext() {
            return false;
        }

        public E next() {
            return null;
        }

        public void remove() {


        }
    }
}
