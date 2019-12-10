package com.yyl.one.thread;

/**
 * author:yangyuanliang Date:2019-12-10 Time:14:20
 **/
public class SimulatedCAS {
    private int value;
    public synchronized int get(){
        return value;
    }

    public synchronized int cas(int expectValue,int newValue){
        int oldValue=value;
        if(oldValue==expectValue){
            value=newValue;

        }
        return oldValue;
    }

    public synchronized  boolean casSet(int expectValue,int newValue){
        return expectValue==cas(expectValue,newValue);
    }
}
