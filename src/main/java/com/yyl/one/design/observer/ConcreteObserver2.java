package com.yyl.one.design.observer;

/**
 * author:yangyuanliang Date:2019-07-18 Time:11:45
 **/
public class ConcreteObserver2 implements Observer{
    @Override
    public void response() {
        System.out.println("观察2回应");
    }
}
