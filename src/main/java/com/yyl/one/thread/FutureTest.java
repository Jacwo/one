package com.yyl.one.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/**
 * author:yangyuanliang Date:2019-12-05 Time:13:38
 **/
public class FutureTest {
    private final FutureTask<ProductInfo> futureTask=new FutureTask<>(new Callable<ProductInfo>() {
        @Override
        public ProductInfo call() throws Exception {
            return loadProductInfo();
        }
    });
    private final Thread thread=new Thread(futureTask);
    public void start(){
        thread.start();
    }
    public ProductInfo get(){
        try {
            return futureTask.get();
        }catch (Exception e){
            e.printStackTrace();
            throw new RuntimeException();
        }
    }

    private ProductInfo loadProductInfo() {
        return new ProductInfo();
    }


    public static void main(String[] args) {
        FutureTest futureTest=new FutureTest();
        futureTest.start();
        System.out.println(futureTest.get());
    }
}
