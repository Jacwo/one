package com.yyl.one.design.decorator;

/**
 * author:yangyuanliang Date:2019-06-27 Time:14:03
 **/
public class Test {
    public static void main(String[] args) {
        Component p=new ConcreteComponent2();
        p.operation();
        Component c=new ConcreteDecorator(p);
        c.operation();
    }
}
