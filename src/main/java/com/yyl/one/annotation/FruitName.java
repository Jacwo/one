package com.yyl.one.annotation;

import java.lang.annotation.*;

/**
 * author:yangyuanliang Date:2019-12-17 Time:15:13
 **/
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface FruitName {
    public String value() default "";
}
