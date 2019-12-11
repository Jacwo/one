package com.yyl.one.thread;

import java.util.concurrent.CountDownLatch;

/**
 * author:yangyuanliang Date:2019-12-11 Time:14:13
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
            //latch.await();
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
