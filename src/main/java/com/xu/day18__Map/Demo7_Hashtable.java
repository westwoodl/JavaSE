package com.xu.day18__Map;

import org.junit.Test;

import java.util.HashMap;
import java.util.Hashtable;

/**
 * 面试题：HashMap和Hashtable区别
 *    HashMap是线程不安全的，效率高JDK1.2，可以存null键和null值
 *    Hashtable是线程安全的，效率低JDK1.0，不可以存null键和null值
 *
 *
 * @deprecated
 * @see java.util.Hashtable
 * @since JDK1.0
 */
public class Demo7_Hashtable {

    @Test
    public void test(){
        try {
            System.out.println(new HashMap<String, Integer>().put(null, null));
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("HashMap occur a error" + e);
        }
        try{
            System.out.println(new Hashtable<String, Integer>().put(null, null));
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("Hashtable occur a error" + e);
        }

    }
}

// C C A C D
// B C C C B

//D