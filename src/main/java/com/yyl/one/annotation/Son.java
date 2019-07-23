package com.yyl.one.annotation;

/**
 * author:yangyuanliang Date:2019-07-23 Time:13:06
 **/
public class Son extends Parent {
    @Override
    public void abstractMethod() {
        System.out.println("子类实现父类的abstractMethod抽象方法");
    }


    @Override
    public void doExtends() {
        System.out.println("子类覆盖父类的doHandle方法");
    }
}
