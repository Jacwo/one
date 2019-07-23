package com.yyl.one.design.proxy;
/**
 * author:yangyuanliang Date:2019-07-18 Time:14:17
 **/
public class Test {
    public static void main(String[] args) {
        ISubject subject=new Subject();
        ProxySubject proxySubject=new ProxySubject();
        ISubject bind = (ISubject) proxySubject.bind(subject);
        bind.action();
    }
}
