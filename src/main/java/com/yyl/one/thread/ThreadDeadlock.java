package com.yyl.one.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * author:yangyuanliang Date:2020-02-06 Time:19:38
 **/
public class ThreadDeadlock {
    static ExecutorService executorService= Executors.newSingleThreadExecutor();
    public static class ReaderPageTask implements Callable<String>{

         @Override
         public String call() throws Exception {
             Future<String> header,footer;
             header=executorService.submit(new Callable<String>() {
                 @Override
                 public String call() throws Exception {
                     System.out.println("header");
                     return "2222";
                 }
             });
             footer=executorService.submit(new Callable<String>() {
                 @Override
                 public String call() throws Exception {
                     System.out.println("footer");

                     return "2222";
                 }
             });
             return header.get()+footer.get();
         }
     }

    public static void main(String[] args) throws Exception {
        ReaderPageTask readerPageTask=new ReaderPageTask();
       String s= readerPageTask.call();
        System.out.println(s);

    }
}
