package com.xu.day21__RW;

/**
 * 装饰者模式：装饰者调用被装饰者类方法，增加功能
 *     增强一个类的功能有两种方法：
 *         1.继承该类，重写方法
 *         2.装饰该类（耦合度低）
 */
public class Demo5_装饰者模式实现 {
}

interface Coder{
    public void code();
}

/**
 * 被装饰类
 */
class Student implements Coder{

    @Override
    public void code() {
        System.out.println("javase");
        System.out.println("javaweb");
    }
}

/**
 * 装饰者
 */
class LearnSelf implements Coder{
    private Coder c;

    public LearnSelf(Coder c){
        this.c = c;
    }
    @Override
    public void code() {
        c.code();
        System.out.println("数据库");
        System.out.println("ssm");
    }
}