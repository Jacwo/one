package com.yyl.one.thread;

import java.util.concurrent.*;

/**
 * author:yangyuanliang Date:2019-12-11 Time:17:41
 **/
public class ScheduledThreadPoolTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ScheduledExecutorService pool= Executors.newScheduledThreadPool(5);
        for (int i = 0; i < 10; i++) {
            ScheduledFuture<Integer> schedule = pool.schedule(new ThreadPoolDemo(), 800, TimeUnit.MILLISECONDS);

            System.out.println(schedule.get());
        }
        pool.shutdown();
    }
    static class ThreadPoolDemo implements Callable<Integer>{

        @Override
        public Integer call() throws Exception {
            int sum=0;
            for (int i = 0; i < 100; i++) {
                sum+=i;
                System.out.println(Thread.currentThread().getName()+"\t"+i);
            }
            return sum;
        }
    }
}
