package com.spring.web.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @author xu rongchao
 * @date 2020/10/8 20:33
 */
// 只扫描 controller
@ComponentScan(value = "com.spring.web", includeFilters =
        {@ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Controller.class)},
useDefaultFilters = false) // 只扫描需要些这个
public class AppConfig extends WebMvcConfigurerAdapter {


    @Override
    public void configureViewResolvers(ViewResolverRegistry registry) {
        registry.jsp("/WEB-INF/view/", ".jsp");
    }
}
