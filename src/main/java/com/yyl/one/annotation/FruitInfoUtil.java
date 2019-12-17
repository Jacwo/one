package com.yyl.one.annotation;

import java.lang.reflect.Field;

/**
 * author:yangyuanliang Date:2019-12-17 Time:15:08
 **/
public class FruitInfoUtil {
    public static  void getFruitInfo(Class<?> clazz){

        Field[] fields=clazz.getDeclaredFields();
        for(Field field:fields){
            if(field.isAnnotationPresent(FruitName.class)){
                FruitName fruitName=field.getAnnotation(FruitName.class);
                String name=fruitName.value();
                System.out.println(name);
            }else if(field.isAnnotationPresent(FruitColor.class)){
                FruitColor fruitName=field.getAnnotation(FruitColor.class);
                String co= String.valueOf(fruitName.fruitColor());
                System.out.println(co);
            }else if(field.isAnnotationPresent(FruitProvider.class)){
                FruitProvider fruitProvider=field.getAnnotation(FruitProvider.class);
                System.out.println(fruitProvider.adress());

            }
        }
    }
}
