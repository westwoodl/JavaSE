package com.xu.day14__reg;


import org.junit.Test;

import java.util.Date;

public class SystemDemo {

    @Test
    public void testGarbageCollection(){
        //System.in;
        for (int i=0;i<1000000;i++)
            new Demo();
        //System.gc();
        System.exit(0);//非零为异常终止
        System.out.println(System.currentTimeMillis());new Date();
        //System.arraycopy();//拷贝数组 ArryList的集合扩增时使用的数组复制就是使用这个
        //native 调用外部非java方法
    }


    class Demo{
        public void method(){

        }

        @Override
        protected void finalize() throws Throwable {
            super.finalize();
            System.out.println("gc时被调用，重写自Object的方法");
        }
    }
    static class StaticInnerClassDemo{

    }

    @Test public void testInner(){
        new Demo().method();
    }
}
class Test4InnerClass{
    //实例化内部类
    SystemDemo.Demo demo = new SystemDemo().new Demo();
    //实例化静态内部类
    SystemDemo.StaticInnerClassDemo sd = new SystemDemo.StaticInnerClassDemo();
}