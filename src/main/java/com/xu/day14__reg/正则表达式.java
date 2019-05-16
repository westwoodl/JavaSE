package com.xu.day14__reg;

import org.junit.Test;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class 正则表达式 {
    @Test public void exe(){
        "hahah".matches("[1-9]\\d[4,14]");
        System.out.println(Arrays.toString("hahahaha".split("h")));
        System.out.println("xu00000rong000chao".replaceAll("\\d*", ""));
        System.out.println("111112223333446678899990".replaceAll("(.)\\1+","$1"));

        /*
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(input);
        return m.matches();
        */

    }

    /**
     * 获取功能
     */
    @Test public void testPatternMatcher(){
        String regx = "1[34578]\\d{9}";
        String s = "xu15797863002, rong 15797863222";
        Pattern p = Pattern.compile(regx);
        Matcher m = p.matcher(s);
        while (m.find())
            System.out.println(m.group());
    }
}
