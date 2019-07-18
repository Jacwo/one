package com.yyl.one.design.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * author:yangyuanliang Date:2019-07-18 Time:11:45
 **/
public abstract class Subject {
    protected List<Observer> observerList;
    public Subject(){
        observerList=new ArrayList<>();
    }
    public void add(Observer observer){
        observerList.add(observer);
    }
    public void remove(Observer observer){
        observerList.remove(observer);
    }
    public abstract void notifyObserver();
}
