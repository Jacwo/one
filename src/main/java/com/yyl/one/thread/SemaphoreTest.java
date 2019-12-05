package com.yyl.one.thread;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.Semaphore;

/**
 * author:yangyuanliang Date:2019-12-05 Time:13:55
 **/
public class SemaphoreTest<T> {
    private final Set<T> set;
    private final Semaphore sem;
    public SemaphoreTest(int bound){
        this.set= Collections.synchronizedSet(new HashSet<>());
        sem=new Semaphore(bound);
    }

    public boolean add(T o) throws InterruptedException {
        //去判断当前信号量类似一个池子，如果池子为空则一直阻塞知道有可用资源
        sem.acquire();
        boolean wasAdded=false;
        try {
            wasAdded=set.add(o);
            return wasAdded;
        }finally {
            if(!wasAdded){
                sem.release();
            }
        }
    }

    public boolean remove(Object o){
        boolean wasRemoved =set.remove(o);
        if(wasRemoved) sem.release();
        return wasRemoved;
    }


    public static void main(String[] args) throws InterruptedException {
        SemaphoreTest semaphoreTest=new SemaphoreTest(3);
        semaphoreTest.add("2222");
        semaphoreTest.add("2222");

        semaphoreTest.add("2222");

        semaphoreTest.add("2222");
        semaphoreTest.add("2222");
        semaphoreTest.add("2222");
    }
}
