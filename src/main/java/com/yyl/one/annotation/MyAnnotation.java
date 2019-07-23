package com.yyl.one.annotation;

import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * author:yangyuanliang Date:2019-07-23 Time:13:03
 **/
//@Inherited   //可以被继承
@Retention(RetentionPolicy.RUNTIME)
public @interface MyAnnotation {
    String value();
}
