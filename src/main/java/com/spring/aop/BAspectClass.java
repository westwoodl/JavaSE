package com.spring.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.Ordered;
import org.springframework.core.PriorityOrdered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @author xu rongchao
 * @date 2020-11-01 17:18
 */
@Component
@Aspect
@Order(Ordered.LOWEST_PRECEDENCE)
public class BAspectClass {

    @Pointcut("execution(* com.spring.aop.AopClass.*(..))")
    public void pointCut(){}

    @Before("pointCut()")
    public void doBefore(JoinPoint joinPoint){
        System.out.println("B-Before Advice...");
    }

    @After("pointCut()")
    public void doAfter(JoinPoint joinPoint){
        System.out.println("B-After Advice...");
    }


    @AfterThrowing("pointCut()")
    public void doAfterThrowing(JoinPoint joinPoint){
        System.out.println("B-AfterThrowing Advice...");
    }

}
