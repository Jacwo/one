package com.yyl.one.thread;
import java.util.concurrent.*;

public class DealThreadPool implements Runnable{

    public static void main(String[] args) {
        int corePoolSize=10;
        int maximumPoolSize=20;
        long keepAliveTime=36;
        TimeUnit unit=TimeUnit.SECONDS;
        Thread thread=new Thread(new RunnableTest());
        thread.start();
        ThreadPoolExecutor executor=new ThreadPoolExecutor(corePoolSize,maximumPoolSize,keepAliveTime,unit,new LinkedBlockingQueue<Runnable>());
        executor.execute(new DealThreadPool());

    }

    @Override
    public void run() {

        while (true){
            String take = LinkedBlockQueueTest.take();
            System.out.println(take);
        }

    }
}
