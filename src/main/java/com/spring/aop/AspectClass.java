package com.spring.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * @author xu rongchao
 * @date 2020-11-01 17:18
 */
@Component
@Aspect
public class AspectClass {

    @Pointcut("execution(* com.spring.aop.AopClass.*(..))")
    public void pointCut(){}

    @Before("pointCut()")
    public void doBefore(JoinPoint joinPoint){
        System.out.println("A-Before Advice...");
    }


    @Around("pointCut()")
    public Object around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("A-around 1");
        try {
            return proceedingJoinPoint.proceed();
        } finally {
            System.out.println("A-around 2");
        }
    }

    @After("pointCut()")
    public void doAfter(JoinPoint joinPoint){
        System.out.println("A-After Advice...");
    }


    @AfterThrowing("pointCut()")
    public void doAfterThrowing(JoinPoint joinPoint){
        System.out.println("A-AfterThrowing Advice...");
    }

}
