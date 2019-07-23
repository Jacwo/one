package com.yyl.one.annotation;

import java.lang.reflect.Method;

/**
 * author:yangyuanliang Date:2019-07-23 Time:13:07
 **/
public class Test {
    public static void main(String[] args) throws NoSuchMethodException {
        Class<Son> clazz=Son.class;
        if(clazz.isAnnotationPresent(MyAnnotation.class)){
            MyAnnotation myAnnotation=clazz.getAnnotation(MyAnnotation.class);
            System.out.println("子类继承到父类类上Annotation,其信息如下："+myAnnotation.value());
        }

        //覆盖测试
        Method methodOverride = clazz.getMethod("doExtends", new Class[] {});
        if (methodOverride.isAnnotationPresent(MyAnnotation.class)) {
            MyAnnotation ma = methodOverride.getAnnotation(MyAnnotation.class);
            System.out.println("子类继承父类的doExtends方法，继承到父类doExtends方法中的Annotation,其信息如下："+ma.value());
        } else {
            System.out.println("子类继承父类的doExtends方法，没有继承到父类doExtends方法中的Annotation");
        }

        //继承测试
        Method method3 = clazz.getMethod("doHandle", new Class[] {});
        if (method3.isAnnotationPresent(MyAnnotation.class)) {
            MyAnnotation ma = method3.getAnnotation(MyAnnotation.class);
            System.out.println("子类覆盖父类的doHandle方法，继承到父类doHandle方法中的Annotation,其信息如下："+ma.value());
        } else {
            System.out.println("子类覆盖父类的doHandle方法，没有继承到父类doHandle方法中的Annotation");
        }
    }
}
