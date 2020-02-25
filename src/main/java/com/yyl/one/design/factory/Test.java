package com.yyl.one.design.factory;

/**
 * author:yangyuanliang Date:2020-02-25 Time:16:16
 **/
public class Test {
    public static void main(String[] args) {
        AbstractFactory concreteFactory=new ConcreteFactory();
        concreteFactory.newProduct().show();
    }
}
