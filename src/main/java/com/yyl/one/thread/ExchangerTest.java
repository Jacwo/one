package com.yyl.one.thread;

import java.util.concurrent.Exchanger;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * author:yangyuanliang Date:2019-12-11 Time:11:35
 **/
public class ExchangerTest {
    private Exchanger<String> exchanger=new Exchanger<>();
    private ExecutorService threadPool= Executors.newFixedThreadPool(2);
    public void start(){
        threadPool.execute(() -> {
            try {
                String A="银行流水A";
                exchanger.exchange(A);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        });



        threadPool.execute(() -> {

            try {
                String B="银行流水B";
                String A=exchanger.exchange("B");
                System.out.println("A和b的数据是否一致A:"+A+A.equals(B)+"B:"+B);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        threadPool.shutdown();

    }

    public static void main(String[] args) {
        new ExchangerTest().start();
    }
}
