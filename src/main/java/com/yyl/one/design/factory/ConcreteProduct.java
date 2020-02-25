package com.yyl.one.design.factory;

/**
 * author:yangyuanliang Date:2020-02-25 Time:16:14
 **/
public class ConcreteProduct implements Product {
    @Override
    public void show() {
        System.out.println("show");
    }
}
