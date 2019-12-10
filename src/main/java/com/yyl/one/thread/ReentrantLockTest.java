package com.yyl.one.thread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * author:yangyuanliang Date:2019-12-09 Time:15:15
 **/
public class ReentrantLockTest {


    static class Ticket implements Runnable{
        private int tickets=100;
        private Lock lock=new ReentrantLock();
        @Override
        public void run() {
            while (true){
                lock.lock();
                try {
                    Thread.sleep(50);
                    if(tickets>0){
                        System.out.println("正在售票"+Thread.currentThread().getName()+"余票"+(--tickets));
                    }
                }catch (Exception e){

                }finally {
                    lock.unlock();
                }
            }
        }
    }

    public static void main(String[] args) {
        Ticket ticket=new Ticket();
        new Thread(ticket,"1号窗口").start();
        new Thread(ticket,"2号窗口").start();
        new Thread(ticket,"3号窗口").start();


    }
}
