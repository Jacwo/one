package com.yyl.one.collection;

import java.util.HashMap;

/**
 * author:yangyuanliang Date:2019-12-20 Time:10:32
 **/
public class HashMapInfiniteLoop {
    private static HashMap<Integer,String> map=new HashMap<>(2,0.75f);

    public static void main(String[] args) {
        map.put(5,"C");
        new Thread(new Runnable() {
            @Override
            public void run() {
                map.put(7,"B");
                System.out.println(map);
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                map.put(3,"A");
                System.out.println(map);

            }
        }).start();
    }
}
