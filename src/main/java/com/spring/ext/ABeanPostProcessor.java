package com.spring.ext;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

/**
 * @author xu rongchao
 * @date 2020/10/18 17:20
 */
@Component
public class ABeanPostProcessor implements BeanPostProcessor {
    public ABeanPostProcessor() {
        System.out.println("ABeanPostProcessor()");
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("a hh before " + beanName);
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("a hh after " + beanName);
        return bean;
    }
}
