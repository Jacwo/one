package com.yyl.one.spring;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @Author yangyuanliang
 * @Date 2023/9/8 10:09
 * @Version 2.0
 **/
@Slf4j
public class OKMain {
    public static void main(String[] args) {
        log.info("Init application context");
        // create and configure beans
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(
                "com.ruijie.spring");

        // retrieve configured instance
        TestSpring spring = (TestSpring) context.getBean("testSpring");

        // print info from beans
        log.info(spring.toString());

        log.info("Shutdown application context");
        context.registerShutdownHook();

    }
}
