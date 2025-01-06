package com.yyl.one.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
@Controller
public class ThreadController {
    public  void aaa(){
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        HttpSession session = request.getSession(false);
        Object aaa = session.getAttribute("aaa");
        System.out.println(aaa);

    }

    @GetMapping("/test")
    @ResponseBody
    public void test(){
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        HttpSession session = request.getSession(true);
        session.setAttribute("aaa","bbbb");
        Thread thread =new Thread(new Runnable() {
            @Override
            public void run() {
                RequestContextHolder.setRequestAttributes(attributes,true);
                aaa();

            }
        });
        thread.start();

        System.out.println("end");
    }


    public static void main(String[] args) {
        String str2 =new StringBuilder("计算机").append("软件").toString();
        System.out.println(str2.intern()  == str2);

        String str =new StringBuilder("ja").append("va").toString();
        System.out.println(str.intern()  == str);


    }
}
