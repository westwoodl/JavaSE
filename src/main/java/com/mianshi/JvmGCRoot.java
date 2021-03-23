package com.mianshi;

/**
 * @author xu rongchao
 * @date 2020/12/13 17:20
 */
public class JvmGCRoot {

    /**
     * 可达性分析，
     * jvm将没有被GCRoot引用的对象视为垃圾
     * 四种GCRoot对象：
     * 1. 虚拟机栈中
     * 的栈帧中的本地变量表中引用的对象
     * 2. 类静态变量
     * 4. 本地方法栈中引用的对象
     */

    public static String a2 = "类静态变量";

    public static final String A3 = "常量";

    public static void main(String[] args) {
        String stackVariable = new String("虚拟机栈中的栈帧中的本地变量表中引用的对象");

    }
}
