package com.yyl.one.aop.config;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @author yyl
 * @date 2018/12/28 22:32
 */
@Component
@Aspect
public class AspectTest {

    @Pointcut("execution(* com.yyl.one.aop.config.dao.*.*(..))")
    public void pointCut(){

    }
    @Before("pointCut()")
    public void before(){
        System.out.println("advice");
    }
}
