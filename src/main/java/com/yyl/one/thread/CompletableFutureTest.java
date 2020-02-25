package com.yyl.one.thread;

import java.util.concurrent.*;

/**
 * author:yangyuanliang Date:2019-12-11 Time:15:06
 **/
public class CompletableFutureTest {
    private ThreadLocalRandom random;

    private ExecutorService executorService= Executors.newCachedThreadPool();
    public Future<Double> getPriceAsync(String product){
        CompletableFuture<Double> future=new CompletableFuture<>();
        executorService.submit(new Runnable() {
            @Override
            public void run() {
                double price=calPrice(product);
                future.complete(price);
            }
        });
        return future;
    }

    private double calPrice(String product) {
        random =ThreadLocalRandom.current();
        delay();
        return random.nextDouble()*product.charAt(0)+product.charAt(1);
    }

    private void delay() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {
        CompletableFutureTest completableFutureTest=new CompletableFutureTest();
        Future<Double> price=completableFutureTest.getPriceAsync("product");
        doSomethingElse();
        try {
            Double result=price.get();
            System.out.println("result:"+result);
        }catch (Exception e){

        }
    }

    private static void doSomethingElse() {
        System.out.println("doSomethingElse");
    }
}
