
package com.yyl.one.controller;

import brave.Span;
import brave.Tracer;
import com.yyl.one.factory.ServiceBeanFactory;
import com.yyl.one.service.IUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * @author yyl
 * @date 2018/11/15 下午10:45
 */

@RestController
@Slf4j
public class HelloController {
    @Autowired
    public IUserService userService;
    @Autowired
    public Tracer tracer;




    @RequestMapping("/index/{number}")
    public String index(@PathVariable int number){
        userService.login();
        //serviceBeanFactory.getUserService().login();
        System.out.println("number = [" + 20/number + "]");
        return "index";
    }

    @GetMapping("/simple-test")
    public String simpleTest() throws InterruptedException {
        Thread.sleep(50);
        log.info("simple");
        userService.login();

        return "This request is automatically traced by Spring Boot";
    }



}

