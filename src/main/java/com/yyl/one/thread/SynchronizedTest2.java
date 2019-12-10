package com.yyl.one.thread;

/**
 * author:yangyuanliang Date:2019-12-09 Time:13:59
 **/
public class SynchronizedTest2 {
    Object lock=new Object();
    public  void fun(){
        synchronized (lock){

            System.out.println("fun");
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static  synchronized void fun3(){
            System.out.println("fun3");
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
    }

    public  static synchronized void fun2(){
            System.out.println("fun2");
    }

    public  void fun4(){
        synchronized (SynchronizedTest2.class){
            System.out.println("fun4");
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    public  void fun5(){
        synchronized (SynchronizedTest2.class){
            System.out.println("fun5");

        }
    }

    public static void main(String[] args) {

        /*new Thread(() -> {
            fun3();
        }).start();
        new Thread(() -> {
           fun2();
        }).start();

        SynchronizedTest2 synchronizedTest2 = new SynchronizedTest2();
        new Thread(() -> {
            synchronizedTest2.fun4();
        }).start();
        new Thread(() -> {
            synchronizedTest2.fun5();
        }).start();*/


        new Thread(() -> {
            new SynchronizedTest2().fun4();
        }).start();
        new Thread(() -> {
            new SynchronizedTest2().fun5();
        }).start();

    }

}
