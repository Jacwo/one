package com.yyl.one.thread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * author:yangyuanliang Date:2019-12-06 Time:17:38
 **/
public class ThreadPrintABCTest {
    static int index = 1;

    public static void main(String[] args) {
        Lock lock = new ReentrantLock();
        Condition condition = lock.newCondition();
        Thread thread1 = new Thread(() -> {
            lock.lock();
            try {
                for (int i = 0; i < 10; i++) {
                    if (index % 3 != 1) {
                        condition.await();
                    } else {

                        index++;
                        System.out.println("a");
                        condition.signalAll();
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }

        });

        Thread thread2 = new Thread(() -> {


            lock.lock();
            try {
                for (int i = 0; i < 10; i++) {
                    if (index % 3 != 2) {
                        condition.await();
                    } else {

                        index++;
                        System.out.println("b");
                        condition.signalAll();
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }

        });


        Thread thread3 = new Thread(() -> {
             lock.lock();
            try {
                for (int i = 0; i < 10; i++) {
                    if (index % 3 != 0) {
                        condition.await();
                    } else {

                        index++;
                        System.out.println("c");
                        condition.signalAll();
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }

        });


        thread1.start();
        thread2.start();

        thread3.start();

    }

}
