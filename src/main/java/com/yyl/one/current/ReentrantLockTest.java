package com.yyl.one.current;


import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockTest implements Runnable {
    private static ReentrantLock lock=new ReentrantLock();
    private static Condition condition=lock.newCondition();
    @Override
    public void run() {
        try {
            lock.lock();
            condition.await();
            System.out.println("条件满足...线程开始运行");
        } catch (InterruptedException e) {


        }finally {
            lock.unlock();
        }

    }

    public static void main(String[] args) throws InterruptedException {
        ReentrantLockTest reentrantLockTest=new ReentrantLockTest();
        Thread thread=new Thread(reentrantLockTest);
        thread.start();
        Thread.sleep(2000);
        System.out.println("通知T1条件满足");
        lock.lock();
        condition.signal();
        lock.unlock();
    }
}
