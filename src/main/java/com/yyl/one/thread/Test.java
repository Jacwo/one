package com.yyl.one.thread;

import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * author:yangyuanliang Date:2019-12-03 Time:13:50
 **/
public class Test {
    static ConcurrentLinkedQueue queue =  new ConcurrentLinkedQueue<>();
    static {
        for(int i = 0; i < 100; i++){
            queue.offer(i);
        }
    }
    public static void main(String[] args) {

        for(int i = 0; i < queue.size(); i++){
            System.out.println(queue.size());
            System.out.println(queue.poll());
        }

    }

}
