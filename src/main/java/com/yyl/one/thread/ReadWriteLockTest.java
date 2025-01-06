package com.yyl.one.thread;

import java.util.HashMap;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * author:yangyuanliang Date:2019-12-10 Time:11:55
 **/
public class  ReadWriteLockTest {
    public static void main(String[] args) {
        HashMap map=new HashMap(2);
        map.put(2,2);
        map.put(3,3);
        map.put(4,4);
      /*  ReadWriteLockDemo demo = new ReadWriteLockDemo();
        for (int i = 0; i < 100; ++i) {
            int finalI = i;
            new Thread(new Runnable() {

                @Override
                public void run() {
                    if(finalI ==3){
                        try {
                            Thread.sleep(10000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    demo.get();

                }
            }, "Read" + i).start();
        }
        for (int i = 0; i < 100; ++i) {
            int finalI = i;
            new Thread(new Runnable() {

                @Override
                public void run() {
                    if(finalI ==4){
                        try {
                            Thread.sleep(10000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    demo.set(222);
                }
            }, "Write").start();
        }*/
    }

    static class ReadWriteLockDemo{
        private ReadWriteLock lock= new ReentrantReadWriteLock();
        private int data=2;
        public void get(){
            lock.readLock().lock();
            try {
                System.out.println("读操作"+data);
            }finally {
                lock.readLock().unlock();
            }
        }

        public void set(int data){
            lock.writeLock().lock();
            try {
                System.out.println("写操作"+data);
                this.data=data;
            }finally {
                lock.writeLock().unlock();
            }
        }
    }
}
