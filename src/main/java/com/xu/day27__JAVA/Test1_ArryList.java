package com.xu.day27__JAVA;

import org.junit.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;

/**
 * 泛型擦除
 * 使用反射，将ArrayList<Integer> 改为ArrayList<String>
 *     泛型只在编译期有效，在运行期会被擦除
 */
public class Test1_ArryList {
    @Test
    public void test() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(11);
        list.add(12);

        Class clazz = ArrayList.class;
        Method method = clazz.getMethod("add", Object.class);

        method.invoke(list, "fuck");

        System.out.println(list);
    }
}
