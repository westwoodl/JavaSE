package com.spring.ext;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * @author xu rongchao
 * @date 2020/10/5 22:09
 */
@Component
public class MyApplicationListener implements ApplicationListener<ApplicationEvent> {

    /**
     * 当 event触发，执行下面的方法
     * @param event 想要监听的事件
     */
    @Override
    public void onApplicationEvent(ApplicationEvent event) {
        System.out.println("收到事件" + event);
    }
}
