package com.yyl.one.design.observer;

/**
 * author:yangyuanliang Date:2019-07-18 Time:11:51
 **/
public class Test {
    public static void main(String[] args) {
        Subject subject=new ConcreteSubject();
        Observer obs1=new ConcreteObserver1();
        Observer obs2=new ConcreteObserver2();
        subject.add(obs1);
        subject.add(obs2);
        subject.notifyObserver();
    }
}



