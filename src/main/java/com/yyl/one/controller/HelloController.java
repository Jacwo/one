/*
package com.yyl.one.controller;

import com.yyl.one.factory.ServiceBeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

*/
/**
 * @author yyl
 * @date 2018/11/15 下午10:45
 *//*

@RestController
public class HelloController {
    @Autowired
    private ServiceBeanFactory serviceBeanFactory;
    @RequestMapping("/index/{number}")
    public String index(@PathVariable int number){
        serviceBeanFactory.getUserService().login();
        System.out.println("number = [" + 20/number + "]");
        return "index";
    }
}
*/
