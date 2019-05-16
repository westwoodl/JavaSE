package com.xu.day19__Exception_File;

import org.junit.Test;

/**
 * 编译时异常（未雨绸缪异常）
 * @see #test() 不try-catch，编译不通过
 * @see CompiletimeException#CompiletimeException(String)
 */
public class Demo2_CompiletimeException {

    @Test
    public void test(){
        try {
            haha(120);
        } catch (CompiletimeException e) {
            System.out.println(e.getMessage());
            System.out.println(e);
            e.printStackTrace();//jvm默认处理异常方式
        }
    }

    int haha(int x) throws CompiletimeException {
        if(x>100)
            throw new CompiletimeException("x大于100");
        return x;
    }
}

class CompiletimeException extends Throwable /*Exception*/{
    CompiletimeException(){}
    CompiletimeException(String m){
        super(m);
    }
}