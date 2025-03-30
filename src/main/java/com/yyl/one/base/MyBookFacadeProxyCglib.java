package com.yyl.one.base;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class MyBookFacadeProxyCglib implements MethodInterceptor{

    private Object target;

    public Object getInstance(Object target) {

        this.target = target;

        Enhancer enhancer = new Enhancer();

        enhancer.setSuperclass(this.target.getClass());

        enhancer.setCallback(this);

        // 创建代理对象
        return enhancer.create();
    }

    @Override
    public Object intercept(Object obj, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("before run!");
        methodProxy.invokeSuper(obj, objects);
        System.out.println("after run!");
        return null;
    }


    public static void main(String[] args) {
        MyBookFacadeProxyCglib myBookFacadeProxyCglib =new MyBookFacadeProxyCglib();
        BookFacadeImpl instance = (BookFacadeImpl) myBookFacadeProxyCglib.getInstance(new BookFacadeImpl());
        instance.addBook();

        List list =new ArrayList(20);
        //list.add("9");
        list.add(9,"1");
        System.out.println(list);
    }
}
