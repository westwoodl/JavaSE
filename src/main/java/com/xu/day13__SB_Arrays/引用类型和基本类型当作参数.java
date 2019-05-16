package com.xu.day13__SB_Arrays;

import org.junit.Test;

/**
 * 重要!
 *     这两种不同类型的参数当作参数,产生的后果完全不一样!
 *
 *     暂时的理解：方法会重新定义一个变量来接收传递过来的参数，但是作为基本类型，方法只是单纯的接受了
 *         传递过来的参数所对应的值，并赋值给本方法中定义的变量，所以在该方法中对该值的改变并不会影响源值。
 *         而对于引用类型当作参数，方法接受的是传递过来的参数所对应的引用，两个引用（即方法中定义的变量
 *         与参数所对应得引用）指向了同一个对象，所以在方法中对该引用的操作会直接影响源值。
 *         总结：作为参数，基本类型传递值，而引用类型传递引用
 *     * String是引用类型，但是作为参数时，是以值传递
 */
public class 引用类型和基本类型当作参数 {
    @Test
    public void exe(){
        //1.基本类型
        int num = 1;
        System.out.println(num);
        change(num);
        System.out.println(num);

        String str = "xu";
        System.out.println(str);
        change(str);
        System.out.println(str);//str没有发生变化

        //2.引用类型
        StringBuffer sb = new StringBuffer("xu");
        System.out.println(sb);
        change(sb);
        System.out.println(sb);//sb是引用类型，值改变了
    }

    private void change(int num) {
        num++;
    }

    private void change(StringBuffer sb) {
        sb.append("rong");
    }

    private void change(String str) {
        str = str + "rong";
    }


}
