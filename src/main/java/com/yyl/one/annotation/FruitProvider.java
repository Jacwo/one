package com.yyl.one.annotation;

import java.lang.annotation.*;

/**
 * author:yangyuanliang Date:2019-12-17 Time:15:06
 *
 * @author yangyuanliang*/
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface FruitProvider {
    public int id() default -1;
    public String name() default "";
    public String adress() default "";
}
