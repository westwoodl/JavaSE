package com.spring.aop;

import org.springframework.stereotype.Component;

/**
 * @author xu rongchao
 * @date 2020-11-01 17:16
 */
@Component
public class AopClass {

    public AopClass() {
        System.out.println("AopClass 构造方法");
    }

    public void someMethod() {
        System.out.println("someMethod");
    }
}
