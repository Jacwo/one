package com.yyl.one.design.observer;

/**
 * author:yangyuanliang Date:2019-07-18 Time:11:49
 **/
public class ConcreteSubject extends Subject{
    @Override
    public void notifyObserver() {
        for (Observer observer:observerList){
            observer.response();
        }
    }
}
