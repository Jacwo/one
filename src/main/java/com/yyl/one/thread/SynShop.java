package com.yyl.one.thread;

import java.util.concurrent.ThreadLocalRandom;

/**
 * author:yangyuanliang Date:2019-12-11 Time:16:09
 **/
public class SynShop {
    private String name;
    public SynShop(String name){
        this.name=name;
    }

    public static void delay(){
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public double getPrice(String product){
        ThreadLocalRandom random=ThreadLocalRandom.current();
        delay();

        return random.nextDouble();
    }
    public String getName() {
        return name;
    }
}
