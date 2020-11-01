package com.spring.web;

import com.spring.web.config.AppConfig;
import com.spring.web.config.RootConfig;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * web容器启动的时候创建对象；调用方法来初始化容器
 *
 * @author xu rongchao
 * @date 2020/10/8 20:25
 */
public class MyWebApplicationInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    /**
     * 获取根容器的配置类 （spring配置）
     * @return
     */
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[]{RootConfig.class};
    }

    /**
     * 获取web容器的配置类 （spring mvc配置）
     * @return
     */
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{AppConfig.class};
    }

    /**
     * 获取DispatchServlet的映射信息
     * /：拦截所有请求，包括静态资源,但是不包括 *.jsp
     * /* : 拦截所有
     * @return
     */
    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }
}
