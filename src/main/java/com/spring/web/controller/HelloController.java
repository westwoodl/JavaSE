package com.spring.web.controller;

import com.spring.web.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author xu rongchao
 * @date 2020/10/8 20:37
 */
@Controller
public class HelloController {
    @Autowired
    private HelloService helloService;

    @ResponseBody
    @RequestMapping("/hello")
    public String hello() {
        return helloService.sayHello();
    }
}
