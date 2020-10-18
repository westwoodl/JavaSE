package com.spring.ext;

import org.springframework.beans.BeansException;
import org.springframework.beans.PropertyValues;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.*;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.beans.PropertyDescriptor;

/**
 * @author xu rongchao
 * @date 2020/10/18 14:27
 */
@Component
public class AngelBean implements BeanFactoryPostProcessor, BeanPostProcessor,
        InstantiationAwareBeanPostProcessor, BeanNameAware, BeanFactoryAware, InitializingBean {

    @PostConstruct
    public void postConstruct() {
        System.err.println("postConstruct-init ? ()");
    }

    @Autowired
    public void setAngelProperty(AngelProperty angelProperty) {
        System.err.println("setAngelProperty" + angelProperty);
    }

    public AngelBean() {
        System.err.println("3 AngelBean()");
    }

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        System.err.println("1 AngelBean.BeanFactoryPostProcessor#postProcessBeanFactory:" + beanFactory);
    }

    /**
     * 除了自己，被人实例化都会被调用
     * @param bean
     * @param beanName
     * @return
     * @throws BeansException
     */
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
//        System.err.println("6 AngelBean.BeanPostProcessor#postProcessBeforeInitialization:" + beanName);
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
//        System.err.println("9 AngelBean.BeanPostProcessor#postProcessBeforeInitialization:" + beanName);
        return bean;
    }

    @Override
    public Object postProcessBeforeInstantiation(Class<?> beanClass, String beanName) throws BeansException {
//        System.err.println("2 AngelBean.InstantiationAwareBeanPostProcessor#postProcessBeforeInstantiation:" + beanName);
        return null;
    }

    @Override
    public boolean postProcessAfterInstantiation(Object bean, String beanName) throws BeansException {
//        System.err.println("AngelBean.InstantiationAwareBeanPostProcessor#postProcessAfterInstantiation:" + beanName);
        return false;
    }

    @Override
    public PropertyValues postProcessPropertyValues(PropertyValues pvs, PropertyDescriptor[] pds, Object bean, String beanName) throws BeansException {
        System.err.println("4 AngelBean.InstantiationAwareBeanPostProcessor#postProcessPropertyValues:" + beanName);
        return null;
    }

    @Override
    public void setBeanName(String name) {
        System.err.println("5 AngelBean.BeanNameAware.setBeanName" + name);
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.err.println("6 AngelBean.BeanNameAware.setBeanFactory" + beanFactory);
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.err.println("8 AngelBean.InitializingBean.afterPropertiesSet");
    }
}
