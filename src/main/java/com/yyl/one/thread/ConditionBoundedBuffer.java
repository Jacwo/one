package com.yyl.one.thread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * author:yangyuanliang Date:2019-12-10 Time:10:08
 **/
public class ConditionBoundedBuffer<T> {
    private static final int BUFFER_SIZE=20;
    protected final Lock lock=new ReentrantLock();
    private final Condition notFull=lock.newCondition();
    private final Condition notEmpty=lock.newCondition();
    private final T[]items= (T[]) new Object[BUFFER_SIZE];
    private int tail;
    private int head;
    private int count;
    public void put(T t) throws InterruptedException {
        lock.lock();
        try {
            while(count==items.length){
                notFull.await();
            }
            items[tail]=t;
            if(++tail==items.length){
                tail=0;
            }
            ++count;
            notEmpty.signal();
        }finally {
            lock.unlock();
        }
    }


    public T take() throws InterruptedException {
        lock.lock();
        try {
            while (count==0){
                notEmpty.await();
            }
            T t=items[head];
            items[head]=null;
            if(++head==items.length){
                head=0;
            }
            --count;
            return t;
        }finally {
            lock.unlock();
        }
    }

    public static void main(String[] args)  {
        ConditionBoundedBuffer<String> conditionBoundedBuffer=new ConditionBoundedBuffer<>();
        new Thread(()->{
            for (int i = 0; i < 30; i++) {
                try {
                    System.out.println(i+"put");
                    conditionBoundedBuffer.put("2222");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();


        new Thread(()->{
            for (int i = 0; i < 20; i++) {
                try {
                    System.out.println(i+"take");
                    conditionBoundedBuffer.take();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
