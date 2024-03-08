package com.yyl.one.spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author yangyuanliang
 * @Date 2023/9/8 10:08
 * @Version 2.0
 **/
@Configuration
public class BeansConfig {
    @Bean(name = "testSpring", initMethod = "doInit", destroyMethod = "doDestroy")
    public TestSpring create() {
        TestSpring testSpring = new TestSpring();
        testSpring.setName("test");
        return testSpring;
    }

}
