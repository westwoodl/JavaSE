package com.xu.day27__JAVA;

import com.xu.day12.C;
import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;


/**
 * 类的加载概述：
 *     加载、链接、初始化
 *
 * 类加载时机：
 *     创建类的实例
 *     访问类的静态变量，或者为静态变量赋值
 *     使用反射方式强制创建某个类或接口对应的java.lang.Class对象
 *     初始化某个类的子类
 *     直接使用java.exe命令运行某个主类
 *
 * 字节码对象每个类只有一个
 *
 * @see Class
 */
public class Demo1_Class {

    @Test
    public void test() throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException, NoSuchFieldException {
        //1.源文件阶段：配置文件
        Class clazz1 = Class.forName("com.xu.day27__JAVA.Person");
        //2.字节码阶段：同步锁使用
        Class clazz2 = Person.class;
        //3.创建对象阶段
        Person person = new Person();
        Class clazz3 = person.getClass();

        System.out.println(clazz1 == clazz2);
        System.out.println(clazz2 == clazz3);


        System.out.println(clazz1.newInstance());//无参构造

        Constructor c = clazz1.getConstructor(int.class, String.class);//获取有参构造
        System.out.println(c.newInstance(1, "xu"));

        Field f = clazz1.getDeclaredField("name");//获取私有字段
        f.setAccessible(true);//获取私有访问权限
        f.set(person, "许");
        System.out.println(f.get(person));

        //获取方法
        Method method = clazz1.getDeclaredMethod("fuck");
        method.setAccessible(true);
        //Method method = clazz1.getMethod("fuck");
        method.invoke(person);

        Method m2 = clazz1.getDeclaredMethod("fuck", int.class);
        m2.setAccessible(true);
        //Method m2= clazz1.getMethod("fuck", int.class);
        m2.invoke(person, 5);
    }

}
class Person{
    private int age;
    private String name;

    private void fuck(){
        System.out.println("通过反射调用我person");
    }

    private void fuck(int num){
        System.out.println(num+"通过反射调用我person");
    }

    public String getName() {
        return name;
    }

    public Person() {
    }

    public Person(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}