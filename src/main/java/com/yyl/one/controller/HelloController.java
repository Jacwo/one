package com.yyl.one.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yyl
 * @date 2018/11/15 下午10:45
 */
@RestController
public class HelloController {
    @RequestMapping("/index/{number}")
    public String index(@PathVariable int number){
        System.out.println("number = [" + 20/number + "]");
        return "index";
    }
}
