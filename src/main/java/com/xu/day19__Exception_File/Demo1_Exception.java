package com.xu.day19__Exception_File;

import org.junit.Test;

/**
 * 除了RuntimeException 及其子类异常（运行时异常）其他都是编译时异常
 * 运行时异常：
 *     程序员的错误
 * 编译时异常：
 *     需要在编译自行处理（try catch）或者 throw给下一层调用者 在main之前必须处理编译时异常
 *
 * main方法没有处理异常，就抛给jvm处理
 * 1.JVM如何处理异常：{@link #test()}
 *     控制台打印，停止程序
 * 2.自己处理异常 {@link #test2()}
 *
 * 子类抛出的异常必须和父类的异常的相等或属于父类异常的子类，多个异常时必须为父类异常的子集
 * @see Throwable
 *     @see Error
 *     @see Exception
 *         @see RuntimeException
 *
 *
 * 客户端开发（安卓），try{}catch(Exception e){捕获异常}
 * 服务端开发（javaee），发生异常不捕获，而是一层一层抛给调用者，直到客户端捕获
 */
public class Demo1_Exception {
    /**
     * 1.JVM如何处理异常：
     */
    @Test
    public void test(){
        System.out.println(div(10, 0));
        System.out.println("这条语句没有运行");
    }

    /**
     * 2.try-catch-finally
     */
    @Test public void test2(){

        try{
            System.out.println(div(10, 0));
            System.out.println(new int[]{1, 2, 3}[10]);
        }catch (ArrayIndexOutOfBoundsException | ArithmeticException e){//JDK7如何处理多个异常
            System.out.println(e);
        }catch (RuntimeException e){
            System.out.println(e);
        }catch (Exception e){
            e.printStackTrace();
        }
        System.out.println("这条语句运行了");
    }



    int div(int a, int b){return a/b;}
}