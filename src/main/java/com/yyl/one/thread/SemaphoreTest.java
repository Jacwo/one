package com.yyl.one.thread;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.Semaphore;

/**
 * author:yangyuanliang Date:2019-12-05 Time:13:55
 * semaphore 与countdown相似，不同的地方在于semaphore的值
 * 被获取到后是可以释放的，并不像countdownlatch那样一直减到底
 * 它也被更多地用来限制流量，类似阀门功能，如果限定某些资源最多
 * 有N个线程可以访问，那么超过N个主不允许再有线程来访问，同时
 * 当现有线程结束后就会释放。然后允许新的线程进来
 *
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
        semaphoreTest.add("22221");
        semaphoreTest.add("22223");
        semaphoreTest.add("22224");
        semaphoreTest.add("22225");
        semaphoreTest.add("2222");
    }
}
