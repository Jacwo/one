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
        //构造方法定义许可资源的个数
        this.semaphore=new Semaphore(bound);
    }

    public boolean add(T t) throws InterruptedException {
        //有没有许可，没有的话将阻塞
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

    public static void main(String[] args) throws InterruptedException {
        BoundedHashSet boundedHashSet=new BoundedHashSet(3);
        for (int i = 0; i <4 ; i++) {
            int finalI = i;
            new Thread(() -> {
                try {
                    boundedHashSet.add("mmm"+ finalI);
                    System.out.println("添加");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }).start();
        }

        /*new Thread(() -> {
            boundedHashSet.remove("222");
            System.out.println("移除");

        }).start();*/


    }
}
