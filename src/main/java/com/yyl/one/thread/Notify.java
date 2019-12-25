package com.yyl.one.thread;

/**
 * author:yangyuanliang Date:2019-12-25 Time:11:46
 **/
public class Notify {

    public static void main(String[] args) {
        final Object lock = new Object();


        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (lock){
                    try {
                        lock.wait();
                        System.out.println("11111");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (lock){
                    try {
                        lock.wait();
                        System.out.println("222222");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();


        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (lock){
                    try {
                        lock.wait();
                        System.out.println("3333");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();


        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (lock){
                    lock.notifyAll();
                    System.out.println("4444");
                }
            }
        }).start();
    }
}
