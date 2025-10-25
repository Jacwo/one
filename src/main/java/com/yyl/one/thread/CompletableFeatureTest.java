package com.yyl.one.thread;

import java.util.concurrent.*;
import java.util.function.Supplier;

public class CompletableFeatureTest {
    /**
     * 主函数入口。
     * 该函数创建一个CompletableFuture对象，并启动一个守护线程，该线程无限循环打印消息。
     * 完成Future的设置和启动线程后，打印一个标识符。
     *
     * @param args 命令行参数（未使用）
     */
    public static void main(String[] args) {
        CompletableFuture<Integer> completableFuture = new CompletableFuture<>(); // 创建一个CompletableFuture对象

        CompletableFuture<String> future1 = CompletableFuture.supplyAsync(() -> "Hello");
        CompletableFuture<String> future2 = CompletableFuture.supplyAsync(() -> "面试鸭");

        CompletableFuture<String> combinedFuture = future1.thenCombine(future2, (result1, result2) -> result1 + " " + result2);

        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> "Hello")
                .thenCompose(result -> CompletableFuture.supplyAsync(() -> result + " 面试鸭"));



        // 创建并启动一个守护线程，该线程会无限循环打印消息


        Thread thread = new Thread(() -> {
            while (true) {
                try {
                    System.out.println("守护线程正在运行...");
                    Thread.sleep(1000); // 每秒打印一次消息
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        thread.setDaemon(true); // 将线程设置为守护线程，确保主程序退出时该线程一同退出

        thread.start(); // 启动线程
        System.out.println(333); // 打印一个标识符

       // Executor executor = ;
        //ExecutorService
        ExecutorService executorService = Executors.newFixedThreadPool(1);

        ThreadLocalRandom current = ThreadLocalRandom.current();
        for (int i = 0; i < 10; i++) {
            int j = current.nextInt(2, 9);
            System.out.println(j);
        }

    }
}
