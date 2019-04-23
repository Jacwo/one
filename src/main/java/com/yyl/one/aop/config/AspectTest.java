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
    //
    //joinpoint 连接点 方法  多个连接点组成一个切面 pointcut
    @Pointcut("execution(* com.yyl.one.aop.config.dao.*.*(..))")
    public void pointCut(){

    }
    @Before("pointCut()")
    public void before(){
        System.out.println("advice");
    }
}
