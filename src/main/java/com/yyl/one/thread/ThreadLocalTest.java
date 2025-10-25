package com.yyl.one.thread;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * author:yangyuanliang Date:2019-11-13 Time:17:41
 **/
public class ThreadLocalTest {
    public static final SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    public static final ThreadLocal<SimpleDateFormat> sdf2 = new ThreadLocal<SimpleDateFormat>() {
        @Override
        protected SimpleDateFormat initialValue() {
            return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        }
    };
    public static void main(String[] args) throws ClassNotFoundException {
        ThreadLocal<Boolean> threadLocal=new ThreadLocal<>();
        threadLocal.set(true);
        System.out.println("main"+threadLocal.get());
        new Thread(new Runnable() {
            @Override
            public void run() {
                threadLocal.set(false);
                System.out.println("thread1"+threadLocal.get());

            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("thread2"+threadLocal.get());

            }
        }).start();
       // InheritableThreadLocal
       /* List ids = null;
        for (int i = 0; i <10 ; i++) {
            ids= Collections.singletonList(i);
        }
        System.out.println(ids);*/
       /* int i = 16 % 16;
        // 00001111
        // 00010000
        int i1 = 16 & 15;
        System.out.println(i);

        System.out.println(i1);*Integer*/

        /*Integer []arr={1,2,3};
        List<Integer> integers = Arrays.asList(arr);
        System.out.println(integers);*/
    /*    for (int i=0;i<100;i++){
            new Thread(() -> {
                Date date = null;
                try {
                    date = sdf.parse("2023-01-01 12:00:00");
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                String formattedDate = sdf.format(date);

                System.out.println(formattedDate);
            }).start();
        }*/

         ExecutorService executor = Executors.newFixedThreadPool(10);
        for (int i = 0; i < 10; i++) {
            executor.execute(new Runnable() {
                @Override
                public void run() {

                    String formattedDate = sdf.format(new Date());

                    System.out.println(formattedDate);
                }
            });
        }

    }
}
