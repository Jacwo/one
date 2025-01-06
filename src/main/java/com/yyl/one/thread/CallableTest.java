package com.yyl.one.thread;

import lombok.SneakyThrows;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

public class CallableTest<Integer> implements Callable<Integer> {
    int i=0;
    @Override
    public Integer call() throws Exception {
        for(;i<20;i++){
            System.out.println(Thread.currentThread().getName()+i);
        }
        return null;
    }

    @SneakyThrows
    public static void main(String[] args) {
        FutureTask futureTask=new FutureTask(new CallableTest());
        Thread thread= new Thread(futureTask,"thread-");
        thread.start();
        System.out.println(futureTask.get());
    }
}
