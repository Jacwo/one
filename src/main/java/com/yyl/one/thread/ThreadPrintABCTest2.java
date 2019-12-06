package com.yyl.one.thread;

import java.util.concurrent.Semaphore;

/**
 * author:yangyuanliang Date:2019-12-06 Time:18:08
 **/
public class ThreadPrintABCTest2 {
    public static void main(String[] args) {
        Semaphore semaphore1=new Semaphore(0);
        Semaphore semaphore2=new Semaphore(0);
        Semaphore semaphore3=new Semaphore(0);
        new Thread(() -> {
            for (int i = 0; i <10 ; i++) {
                try {
                    semaphore1.acquire();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                System.out.println("a");
                semaphore2.release();

            }

        }).start();
        new Thread(() -> {
            for (int i = 0; i <10 ; i++) {
                try {
                    semaphore2.acquire();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                System.out.println("b");
                semaphore3.release();

            }
        }).start();
        new Thread(() -> {
            for (int i = 0; i <10 ; i++) {
                try {
                    semaphore3.acquire();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                System.out.println("c");
                semaphore1.release();

            }
        }).start();
    }
}
