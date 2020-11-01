package com.spring.ext;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * @author xu rongchao
 * @date 2020/10/4 21:00
 */
@Component
public class MyBeanPostProcessor implements BeanFactoryPostProcessor {

    public MyBeanPostProcessor() {
        System.out.println("MyBeanPostProcessor");
    }

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        System.out.println("bean definition count" + Arrays.toString(beanFactory.getBeanDefinitionNames()));
    }
}
