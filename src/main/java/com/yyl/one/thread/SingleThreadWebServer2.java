package com.yyl.one.thread;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * author:yangyuanliang Date:2019-12-05 Time:15:18
 * version 2.0
 * 主线程仍然不断地交替执行，接收外部链接和分发请求操作，区别在于对于每个链接
 * 主循环将创建一个新线程来处理请求。而不是在主循环中处理
 *
 **/
public class SingleThreadWebServer2 {
    public static void main(String[] args) throws IOException {
        ServerSocket socket=new ServerSocket(80);
        while (true){
            final Socket connect=socket.accept();
            Runnable task= () -> handleRequest(connect);
            new Thread(task).start();
        }
    }

    private static void handleRequest(Socket connect) {
        System.out.println("deal connect");
    }
}
