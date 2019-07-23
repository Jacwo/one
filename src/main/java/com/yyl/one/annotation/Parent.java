package com.yyl.one.annotation;

/**
 * author:yangyuanliang Date:2019-07-23 Time:13:05
 **/
@MyAnnotation("类的注解")
public abstract class Parent {
    @MyAnnotation(value = "父类的abstractMethod方法")
    public abstract void abstractMethod();

    @MyAnnotation(value = "父类的doExtends方法")
    public void doExtends() {
        System.out.println(" ParentClass doExtends ...");
    }

    @MyAnnotation(value = "父类的doHandle方法")
    public void doHandle(){
        System.out.println(" ParentClass doHandle ...");
    }

}
