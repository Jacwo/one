package com.yyl.one.thread;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.Semaphore;

/**
 * author:yangyuanliang Date:2019-12-10 Time:19:19
 **/
public class BoundedHashSet<T> {
    private final Set<T> set;
    private Semaphore semaphore;
    public BoundedHashSet(int bound){
        this.set= Collections.synchronizedSet(new HashSet<>());
        this.semaphore=new Semaphore(bound);
    }

    public boolean add(T t) throws InterruptedException {
        semaphore.acquire();
        boolean wasAdded=false;
        try {
            wasAdded=set.add(t);
            return wasAdded;
        }finally {
            if(!wasAdded){
                semaphore.release();
            }
        }
    }

    public boolean remove(Object o){
        boolean wasRemoved=set.remove(o);
        if(wasRemoved){
            semaphore.release();
        }
        return wasRemoved;
    }
}
