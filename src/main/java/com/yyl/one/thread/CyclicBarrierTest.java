package com.yyl.one.thread;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * author:yangyuanliang Date:2019-12-19 Time:15:23
 *
 *  cyclicBarrier主要实现了多个线程之间相互等待，直到所有线程都满足了条件之后才能继续执行
 *  后续的操作。描述的多个线程内部相互等待的关系
 *  cyclicBarruer可以被重置而重复使用
 **/
public class CyclicBarrierTest {
    private static CyclicBarrier barrier=new CyclicBarrier(5);

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService= Executors.newCachedThreadPool();
        for(int i=0;i<10;i++){
            final int threadNum=i;
            Thread.sleep(1000);
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        reace(threadNum);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } catch (BrokenBarrierException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
    }

    private static void reace(int threadNum) throws InterruptedException, BrokenBarrierException {
        Thread.sleep(1000);
        System.out.println("{ } is ready"+threadNum);
        barrier.await();
        System.out.println("{ } is continue"+threadNum);

    }
}
