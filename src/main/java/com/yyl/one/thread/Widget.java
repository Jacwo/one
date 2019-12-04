package com.yyl.one.thread;

/**
 * author:yangyuanliang Date:2019-12-03 Time:09:34
 **/
public class Widget {
    public synchronized void doSomething(){
        System.out.println("parent do something");
    }
}
