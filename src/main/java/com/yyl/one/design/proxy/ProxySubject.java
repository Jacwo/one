package com.yyl.one.design.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * author:yangyuanliang Date:2019-07-18 Time:14:13
 **/
public class ProxySubject implements InvocationHandler {
    public Object object;
    public ProxySubject(Object o){
        this.object=o;
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("before ");
        method.invoke(object,args);
        System.out.println("after");
        return null;
    }
}
