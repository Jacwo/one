package com.yyl.one.thread;

/**
 * author:yangyuanliang Date:2019-12-03 Time:09:34
 **/
public class LoggingWidget extends Widget {
    @Override
    public synchronized void doSomething(){
        System.out.println("son dosomething");
        super.doSomething();
    }

    public static void main(String[] args) {
        Widget loggingWidget=new LoggingWidget();
        loggingWidget.doSomething();
    }
}
