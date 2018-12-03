package com.yyl.one.thread;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.*;

/**
 * @author yyl
 * @date 2018/12/3 下午10:55
 */
public class ThreadTest {
    public static void main(String[] args) {
        // 线程个数固定
        //ExecutorService threadPool = Executors.newFixedThreadPool(5);
        //一个线程执行操作
        //ExecutorService threadPool = Executors.newSingleThreadExecutor();
         List<Future<String>> resultList = new ArrayList<Future<String>>();
        // 线程定时完成操作
        // ScheduledThreadPoolExecutor  threadPool = (ScheduledThreadPoolExecutor) Executors.newScheduledThreadPool(10);
        ExecutorService threadPool = Executors.newCachedThreadPool();
        for(int i = 0; i < 10; i++) {
            Future<String> future=threadPool.submit(new Callable<String>() {

                @Override
                public String call() throws Exception {
                    // TODO Auto-generated method stub
                    //int cpuNums = Runtime.getRuntime().availableProcessors();
                    //System.out.println(cpuNums);
                    for (int i = 999999; i > 0; i--) ;
                    System.out.println("call()方法被自动调用,干活！！！             " + Thread.currentThread().getName());
                    //Thread.sleep(1000);
                    return "call()方法被自动调用，任务的结果是：   " + Thread.currentThread().getName();
                }
            });
            resultList.add(future);
        }
        threadPool.shutdown();  //执行到此处并不会马上关闭线程池,但之后不能再往线程池中加线程，否则会报错
        System.out.println("Main: Finished all threads at"+ new Date());
        for (Future<String> fs : resultList) {
            try {
                System.out.println(fs.get());     //打印各个线程（任务）执行的结果
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            } finally {

            }
        }
    }
}
