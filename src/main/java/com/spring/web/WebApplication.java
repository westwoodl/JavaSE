package com.spring.web;

import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @author xu rongchao
 * @date 2020/10/8 20:02
 */
public class WebApplication {

    /**
     * 1. web容器在启动的时候，会扫描每个jar包下的 META-INF/services/javax.servlet.ServletContainer
     * 2. 加载这个文件指定的类 {@link org.springframework.web.SpringServletContainerInitializer}
     * 3. spring的应用一启动会加载感兴趣的WebApplicationInitializer接口的下的所有组件
     * 4. 并且为WebApplicationInitialization 组件创建对象
     *     1. {@link org.springframework.web.context.AbstractContextLoaderInitializer} 创建根容器
     *     2. {@link org.springframework.web.servlet.support.AbstractDispatcherServletInitializer}
     *         创建一个web的ioc容器，创建 DispatchServlet、将 DispatchServlet加入到 ServletContext
     *     3. {@link org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer}
     *         注解方式配置的DispatchServlet：1. 创建根容器 2. 创建web ioc容器
     *
     * 总结：以注解的方式来启动 SpringMVC，继承 AbstractAnnotationConfigDispatcherServletInitializer
     *
     * 5. {@link WebMvcConfigurerAdapter} 以实现众多配置
     *
     * servlet3.0
     */

}
