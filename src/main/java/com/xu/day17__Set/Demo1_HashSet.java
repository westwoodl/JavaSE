package com.xu.day17__Set;

import org.junit.Test;

import java.util.HashSet;

/**
 * set 无序，无索引，无重复
 *     当hashCode()返回相同时（即发生了哈希冲突），才调用equals()
 *      Object 的 hashcode 方法是本地方法，也就是用 c 语言或 c++ 实现的，该方法直接返回对象的 内存地址。
 *      https://blog.csdn.net/qq_38182963/article/details/78940047
 */
public class Demo1_HashSet {


    @Test
    public void test(){
        HashSet<Integer> h = new HashSet<>();
    }

}
