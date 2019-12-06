package com.yyl.one.thread;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * author:yangyuanliang Date:2019-12-05 Time:15:12
 * vsesion 1.0
 * 一次只能处理一个请求主线程在接收与处理相关请求操作之间不断交替运行
 *
 *
 **/
public class SingleThreadWebServer {
    public static void main(String[] args) throws IOException {
        ServerSocket  socket=new ServerSocket(80);
        while (true){
            Socket connection=socket.accept();
            handleRequest(connection);
        }
    }

    private static void handleRequest(Socket connection) {
        System.out.println("deal connection");
    }
}
