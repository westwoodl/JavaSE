package com.spring.ext;

import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.support.AbstractApplicationContext;

import java.util.Arrays;

/**
 * @author xu rongchao
 * @date 2020/10/4 20:54
 */
@ComponentScan("com.spring.ext")
public class ExtApplication {

    /**
     * ---------------------- spring 扩展原理 ----------------------------
     * 基本概念
     * 1. BeanFactory 按照 BeanDefinitionRegistry里面保存的每一个bean定义信息创建bean实例
     *
     *
     * 一、后置处理器
     * {@link BeanPostProcessor}：bean对象初始化前后
     * {@link org.springframework.beans.factory.config.BeanFactoryPostProcessor} ：
     *     时机：beanFactory标准初始化之后调用（所有的bean definition 已经被加载，但是没有bean被初始化的时候执行）
     *     用处：这允许重写或添加属性，甚至可以将属性添加到急切的初始化bean。
     * {@link org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor} :
     *     modify the application context's internal bean definition after its standard initialization
     *     时机：所有的bean definition 将要被加载时执行，没有bean被初始化的时候执行
     *     用处：在下一个后处理阶段开始之前添加更多的bean定义。
     * 原理：
     *     1. ioc创建对象
     *     2. refresh
     *         1. invokeBeanFactoryPostProcessor
     *              1. 从容器中获取所有的BeanDefinitionRegistryPostProcessor组件，
     *              2. 执行postProcessBeanDefinitionRegistry
     *              3. 触发postProcessBeanFactory
     *              4. 找到beanFactoryPostProcessor组件，然后依次触发
     *
     * 二、spring监听器
     * 1. {@link org.springframework.context.ApplicationListener}：实现此接口，以（监听）容器中发布的事件。
     *    {@link org.springframework.context.ApplicationEvent} 子类事件 1.刷新 2.close 3. start 4. stop
     *     （发布） 自定义的事件 {@link AbstractApplicationContext#publishEvent}，【观察者模式】：获取所有的listener，然后调用
     *     怎么获取事件派发器的呢？：
     *         1. refresh() -> {@link AbstractApplicationContext#initApplicationEventMulticaster()}
     *     怎么注册事件呢？:将事件注册到派发器中
     *         {@link AbstractApplicationContext#registerListeners()}
     * 2. {@link org.springframework.context.event.EventListener}：在任何方法上加上该注解，以（监听）容器中发布的事件。
     *     原理：{@link org.springframework.context.event.EventListenerMethodProcessor}
     *     {@link org.springframework.beans.factory.SmartInitializingSingleton}
     *         1. refresh()
     *             2. {@link AbstractApplicationContext#finishBeanFactoryInitialization}; 初始化剩下的bean
     *                 3. getBean() 创建所有的bean
     *                 4. {@link DefaultListableBeanFactory#preInstantiateSingletons()}获取所有的bean，判断是不是 SmartInitializingSingleton类型，如果是则调用
     * 3. 发现了一个挺好的东西 {@link org.springframework.transaction.event.TransactionalEventListener}, 默认为事务提交后触发该注解修饰的方法
     *
     * 三、refresh 方法概述 {@link AnnotationConfigApplicationContext#refresh()}
     * 1. prepareRefresh {@link AnnotationConfigApplicationContext#prepareRefresh()}
     *     1. initPropertySource() 初始化属性设置；子类可以自定义个性化的属性设置
     *     2. getEnvironment().validateRequiredProperties();检验环境属性的合法
     *     3. earlyApplicationEvents = new LinkedHashSet() 保存容器的早期事件
     * 2. obtainFreshBeanFactory 获取beanFactory{@link AnnotationConfigApplicationContext#obtainFreshBeanFactory()}
     *     1. refreshBeanFactory
     *     2 getBeanFactory() 获取GenericApplicationContext的beanFactory
     * 3. prepareBeanFactory(beanFactory);BeanFactory的预备工作 {@link AbstractApplicationContext#prepareBeanFactory(org.springframework.beans.factory.config.ConfigurableListableBeanFactory)}
     *     1. 设置BeanFactory的类加载器，表达式解析器...
     *     2. 添加部分BeanPostProcessor {@link org.springframework.context.support.ApplicationContextAwareProcessor}
     *     3. 设置忽略的自动装配接口
     *     4. 注册可以解析的自动装配，我们能直接在任何组件中自动注入 BeanFactory ResourceLoader ApplicationEventPublisher ApplicationContext
     *     5. 添加BeanFactoryProcessor: ApplicationListenerDetector
     *     6. 添加编译时AspectJ
     *     7. 给BeanFactory注册能用的组件 environment ConfigurableEnvironment, systemProperties Map<String, Object>, systemEnvironment
     * 4. postProcessBeanFactory, 准备工作完成后进行的后置处理工作，
     *     AnnotationConfigApplicationContext没有重写这个方法，啥也没干
     * -- 至此 spring 完成了 BeanFactory的准备工作 --
     * 5. invokeBeanFactoryPostProcessors，调用用户 实现的 BeanFactoryPostProcessor
     * 6. registerBeanPostProcessors， 注册BeanPostProcessor
     * 7. initMessageSource() 初始化MessageSource组件（国际化功能：消息绑定，消息解析）
     * 8. initApplicationEventMulticaster() 初始化事件派发器
     *
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(Arrays.toString(args));
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ExtApplication.class);
        // publish custom application event
        context.publishEvent(new ApplicationEvent("xu's custom application event") {
        });
    }
}
