package com.yyl.one.thread;

public class ThreadTest1 extends Thread {
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
    }

    public static void main(String[] args) {
        for (int i=0;i<10;i++){
            ThreadTest1 threadTest1=new ThreadTest1();
            threadTest1.start();
        }

    }
}
