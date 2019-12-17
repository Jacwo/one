package com.yyl.one.annotation;

import java.lang.annotation.*;

/**
 * author:yangyuanliang Date:2019-12-17 Time:15:02
 *
 * @author yangyuanliang*/
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface FruitColor {
    public enum Color{
        BLUE,RED,GREEN
    }
    Color fruitColor() default Color.GREEN;


}
