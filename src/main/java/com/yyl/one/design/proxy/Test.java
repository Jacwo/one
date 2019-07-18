package com.yyl.one.design.proxy;

import java.lang.reflect.Proxy;

/**
 * author:yangyuanliang Date:2019-07-18 Time:14:17
 **/
public class Test {
    public static void main(String[] args) {
        ISubject subject=new Subject();
        ISubject proxyInstance = (ISubject) Proxy.newProxyInstance(subject.getClass().getClassLoader(), subject.getClass().getInterfaces(), new ProxySubject(subject));
        proxyInstance.action();
    }
}
