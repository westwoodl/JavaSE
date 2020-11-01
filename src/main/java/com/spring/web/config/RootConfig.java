package com.spring.web.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Controller;

/**
 * @author xu rongchao
 * @date 2020/10/8 20:35
 */
// 不扫描 controller
@ComponentScan(value = "com.spring.web", excludeFilters =
        {@ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Controller.class)})
public class RootConfig {
}
