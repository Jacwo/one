package com.yyl.one.thread;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class LinkedBlockQueueTest {
    private static BlockingQueue<String> msgQueue =
            new LinkedBlockingQueue<>();

    public static void add(String integer){
        msgQueue.add(integer);
    }
    public static String take(){
        try {
            return  msgQueue.take();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return null;
    }
}
