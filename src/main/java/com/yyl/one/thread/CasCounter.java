package com.yyl.one.thread;

/**
 * author:yangyuanliang Date:2019-12-10 Time:14:30
 **/
public class CasCounter {
    private SimulatedCAS value=new SimulatedCAS();
    public int getValue(){
        return value.get();
    }

    public int increment(){
        int v;
        do{
           v=value.get();
        }while (v!=value.cas(v,v+1));
        return v+1;
    }


    public static void main(String[] args) {
        CasCounter casCounter=new CasCounter();
        for (int i=0;i<10;i++){
            int increment = casCounter.increment();
            System.out.println(increment);
        }

    }
}
