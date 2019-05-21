package com.xu.day27__JAVA;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * jdk8 新特性
 * 1.接口中的静态方法和默认方法{@link #test1()}
 * 2.{@link #test2()}
 * 3.Lambda表达式{@link #test3()}和函数式接口{@link Functional}重点
 * 4.方法引用 {@link #test4()}
 */
public class jdk8 {

    /**
     * 1.在jdk8中 接口中可以声明有实现体的静态方法和默认方法。默认方法可以被重写
     */
    interface Inter {
        public default void unImplMethod(){
            System.out.println("helloword");
        }
        public static void staticMethod(){
            System.out.println("i'm static method ");
        }
    }
    class Impl implements Inter {
        @Override
        public void unImplMethod() {
            System.out.println("helloword Implements");
        }
    }
    @Test
    public void test1(){
        Inter i = new Impl();
        i.unImplMethod();
        //静态方法的调用
        Inter.staticMethod();
    }

    /**
     * 2.在jdk7 之前 局部内部类使用方法中的局部变量时，必须用final修饰
     * jdk8 后 系统会默认为你加上final
     */
    @Test public void test2(){
        new InnerClass().fun();

        int num2 = 10;//默认加上final
        class InnerMethodClass {
            public void fun(){
                //num2 = 20;//编译不通过
                System.out.println(num2);
            }
        }
    }
    public int num = 10;
    class InnerClass{
        public void fun(){
            System.out.println(num = 20);
        }
    }

    /**
     * 3.Lambda 就是简化的匿名内部类
     * (parameters) -> expression
     * (parameters) ->{ statements; }
     */
    @Test public void test3(){

        Arrays.asList("a", "b", "c").forEach(e ->{
            System.out.println(e);
        });

        //7 的写法：
        MathOperation addition7 = new MathOperation() {
            @Override
            public int operation(int a, int b) {
                return a+b;//a*b;a/b;
            }
        };

        //8 的写法：
        // 类型声明
        MathOperation addition = (int a, int b) -> a + b;
        // 不用类型声明
        MathOperation subtraction = (a, b) -> a - b;
        // 大括号中的返回语句
        MathOperation multiplication = (int a, int b) -> { return a * b; };
        // 没有大括号及返回语句
        MathOperation division = (int a, int b) -> a / b;

        System.out.println(addition.operation(3, 4));
        System.out.println(subtraction.operation(3, 4));
        System.out.println(multiplication.operation(3, 4));
        System.out.println(division.operation(3, 4));

        Functional functional = s -> new String(s.replaceAll(" ", ""));
        System.out.println(functional.method("cao ni ma"));

        new Thread(() -> {
            while (true) System.out.println("111");
        }).start();


    }
    interface MathOperation {
        int operation(int a, int b);
    }

    @FunctionalInterface
    interface Functional {
        public abstract String method(String s);

        public static void cao(){
        }
    }

    /**
     * 4.方法引用
     */
    @Test public void test4(){

        //1.无参构造
        Supplier<Car> sup = Car::new;
        //Car car = Car.create(sup);
        Car car = sup.get();
        System.out.println(car);

        //
        //Function<Integer, Car> fun = (x) -> new Car(x);
        Function<Integer, Car> fun = Car::new;
        Car car2 = fun.apply(111);
        System.out.println(car);



        List cars = Arrays.asList(car);

        //cars.forEach(Car::);
    }

//    @FunctionalInterface
//    public interface Supplier<T> {
//        T get();
//    }
    static class Car {
        private int age;

        public Car(){
        }
        public Car(int age){
            this.age = age;
        }

        public static Car create(final Supplier<Car> supplier) {
            return supplier.get();
        }

        @Override
        public String toString() {
            return age+"";
        }

        public void show(){
            System.out.println(this);
        }
    }
}
