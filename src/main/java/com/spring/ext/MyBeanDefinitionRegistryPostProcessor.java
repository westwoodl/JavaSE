package com.spring.ext;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.stereotype.Component;

/**
 * @author xu rongchao
 * @date 2020/10/5 10:56
 */
@Component
public class MyBeanDefinitionRegistryPostProcessor implements BeanDefinitionRegistryPostProcessor {
    @Override
    public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry registry) throws BeansException {
        System.out.println("MyBeanDefinitionRegistryPostProcessor postProcessBeanDefinitionRegistry: " + registry.getBeanDefinitionCount());
        BeanDefinition beanDefinition = new RootBeanDefinition(OneBean.class);
        // root bean definition 的第二种方式
        BeanDefinitionBuilder.rootBeanDefinition(OneBean.class);
        registry.registerBeanDefinition("com.spring.ext.MyBeanDefinitionRegistryPostProcessor.OneBean", beanDefinition);
    }

    static class OneBean {

    }

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        System.out.println("MyBeanDefinitionRegistryPostProcessor postProcessBeanFactory: " + beanFactory.getBeanDefinitionCount());
    }
}
