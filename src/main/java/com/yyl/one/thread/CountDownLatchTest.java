package com.yyl.one.thread;

import java.util.concurrent.CountDownLatch;

/**
 * author:yangyuanliang Date:2019-12-11 Time:14:13
 *
 * countdownlatch是一个计数器闭锁，通过他可以完成类似于阻塞当前线程的功能
 * 即一个线程或者多个线程一直等待，直到其他线程执行操作的完成。
 * 用一个给定的计数器来初始化，该计数器的操作是原子操作，即同时只能有一个线程去
 * 操作该计数器。调用该类的await方法的线程会一直处于阻塞状态，直到其他线程调用countdown
 * 方法使当前计数器的值变为0
 * 当计数器值为0的时候因await方法而处于等待状态的线程就会继续往下执行。
 *
 *

 *
 **/
public class CountDownLatchTest {
    public static void main(String[] args) {
        CountDownLatch latch=new CountDownLatch(5);
        LatchDemo latchDemo=new LatchDemo(latch);
        long begin=System.currentTimeMillis();
        for (int i = 0; i < 5; i++) {
            new Thread(latchDemo).start();
        }
        try{
            latch.await();
        }catch (Exception e){
            e.printStackTrace();
        }
        long end=System.currentTimeMillis();
        System.out.println("总耗时"+ (end-begin));
    }


    static class LatchDemo implements Runnable{
        private CountDownLatch latch;
        public LatchDemo(CountDownLatch latch){
            this.latch=latch;
        }
        @Override
        public void run() {
            try {
                for (int i=0;i<50000;i++){
                    if(i%2==0){
                        System.out.println(i);
                    }
                }
            }finally {
                latch.countDown();
            }
        }
    }
}
