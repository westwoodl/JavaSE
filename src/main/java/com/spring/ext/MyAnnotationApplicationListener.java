package com.spring.ext;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

/**
 * @author xu rongchao
 * @date 2020/10/5 23:16
 */
@Component
public class MyAnnotationApplicationListener {

    @EventListener(ApplicationEvent.class)
    public void oneEventListener(ApplicationEvent event) {
        System.out.println("annotation '@EventListener' listen event" + event);

    }
}
