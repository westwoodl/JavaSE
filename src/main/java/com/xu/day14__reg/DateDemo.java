package com.xu.day14__reg;

import org.junit.Test;

import java.text.DateFormat;
import java.util.Date;

public class DateDemo {

    @Test
    public void test(){
        System.out.println(new Date(0));//东8区，为8点，其实为0.CST可视为美国、澳大利亚、古巴或中国的标准时间。

        DateFormat df = DateFormat.getDateInstance();//获取子类SimpleDateFormat的实例
        System.out.println(df);
    }
}
