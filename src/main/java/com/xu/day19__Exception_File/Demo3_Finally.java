package com.xu.day19__Exception_File;

import org.junit.Test;

import java.util.Arrays;

/**
 * finally{
 *     即使之前已经return，finally也会被执行！！
 *     （先执行return，再执行finally{@link #intTest()}）
 *     只有在System.exit()后不会运行
 *     用于释放资源，io， database
 * }
 *
 * 三个final
 * final
 * @see Object#finalize()
 */
public class Demo3_Finally {
    @Test
    public void test(){
        System.out.println(intTest());
        System.out.println(Arrays.toString(arrTest()));
    }

    /**
     * @return return会在finally之前运行
     */
    int intTest(){
        int x;
        try {
            x = 20;
            throw new Exception("exception");
        } catch (Exception e) {
            System.out.println(e);
            //System.exit(0);//
            x = 30;
            return x;
        }finally {
            x = 40;
            System.out.println("return后执行finally");
        }
    }

    /**
     * @return 引用类型在finally里被改变了
     */
    int[] arrTest(){
        int x[] = new int[]{0};
        try {
            throw new Exception("exception");
        } catch (Exception e) {
            System.out.println(e);
            //System.exit(0);//
            x[0] = 30;
            return x;
        }finally {
            x[0] = 40;
            System.out.println("return后执行finally");
        }
    }
}
