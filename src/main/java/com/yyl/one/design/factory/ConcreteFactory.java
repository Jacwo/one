package com.yyl.one.design.factory;

/**
 * author:yangyuanliang Date:2020-02-25 Time:16:13
 **/
public class ConcreteFactory implements AbstractFactory{

    @Override
    public Product newProduct() {
        return new ConcreteProduct();
    }
}
