package com.yyl.one.design.command;

/**
 * author:yangyuanliang Date:2019-07-18 Time:13:13
 **/
public class Test {
    public static void main(String[] args) {
        Invoker invoker=new Invoker(new ConcreteCommand1());
        invoker.call();
    }
}
