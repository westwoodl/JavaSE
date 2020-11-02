package com.spring.aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @author xu rongchao
 * @date 2020-11-01 17:15
 */

@ComponentScan("com.spring.aop")
@EnableAspectJAutoProxy
public class AopApplication {

    /**
     * aop 源码：
     * org.springframework.aop.framework.ReflectiveMethodInvocation#proceed()
     * 调用org.aopalliance.intercept.MethodInterceptor的实现类
     */
    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AopApplication.class);
        AopClass aopClass = applicationContext.getBean(AopClass.class);
        aopClass.someMethod();
    }

}
