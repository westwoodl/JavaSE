package com.xu.day22__prop;

import org.junit.Test;

import java.io.*;
import java.util.ArrayList;

/**
 * 对象流，用于序列化和反序列化
 * 实体类必须实现序列化接口，否则抛出异常
 * @throw NotSerializableException
 *
 * {@link #test2()} 读不到对象时会抛出异常：存为一个list，write一次，read一次
 * @throws EOFException end of file
 *
 *  serialVersionUID 不同的serialVersionUID，抛出异常
 * @throws InvalidClassException
 *
 * 关于版本号serialVersionUID：自动生成随机
 *
 * @see java.io.ObjectInputStream 反序列化
 * @see java.io.ObjectOutputStream 序列化
 */
public class Demo4_ObjectIOStream {
    @Test
    public void test() throws IOException {
        Person p1 = new Person("xu", 1);
        Person p2 = new Person("xx", 2);

        ArrayList<Person> list = new ArrayList<>();
        list.add(p1);
        list.add(p2);

        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("file.txt"));
        oos.writeObject(list);

        oos.close();
    }

    @Test
    public void test2() throws IOException, ClassNotFoundException {
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("file.txt"));

        System.out.println((ArrayList) ois.readObject());
        //System.out.println((Person) ois.readObject());
        /**
         * @throws EOFException
         */
        //System.out.println((Person) ois.readObject());

        ois.close();
    }

}




class Person implements Serializable {

    private static final long serialVersionUID = 1L;

    private String name;
    private int age;

    public Person() {
        super();
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
}