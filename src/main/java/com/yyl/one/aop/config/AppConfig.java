package com.yyl.one.aop.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @author yyl
 * @date 2018/12/28 22:21
 */
@Configuration
@ComponentScan("com.yyl.one.aop")
@EnableAspectJAutoProxy
public class AppConfig {
}
