package com.yyl.one.thread;

import java.util.concurrent.CountDownLatch;

/**
 * author:yangyuanliang Date:2019-12-04 Time:18:28
 **/
public class TimerTaskTest{
    public static long timerTashs(int nthreads,final Runnable task)   {
        final CountDownLatch startGate=new CountDownLatch(1);
        final CountDownLatch endGate=new CountDownLatch(nthreads);
        for (int i = 0; i < nthreads; i++) {
            Thread t=new Thread(() -> {
                try {
                    //Causes the current thread to wait until the latch
                    // has counted down to zero, unless the thread is interrupted
                    startGate.await();
                    try {
                        task.run();

                    }finally {
                        endGate.countDown();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
            t.start();
        }
        long start=System.nanoTime();
        startGate.countDown();
        long end=System.nanoTime();
        return end-start;
    }


    public static void main(String[] args) throws InterruptedException {
        Runnable task= () -> System.out.println("sss");

        System.out.println(timerTashs(5,task));
    }
}