package com.yyl.one.thread;

import java.util.UUID;

public class RunnableTest implements Runnable {
    @Override
    public void run() {
        int k=0;
        do {
            LinkedBlockQueueTest.add(UUID.randomUUID().toString().replaceAll("-",""));
            System.out.println(Thread.currentThread().getName()+k);
            k++;
        }while (k<100);
      //  k++;

    }

    public static void main(String[] args) {
        for (int i=0;i<100;i++){
            Thread thread =new Thread(new RunnableTest());
            thread.start();
        }

    }
}
