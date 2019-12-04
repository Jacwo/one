package com.yyl.one.thread;

/**
 * author:yangyuanliang Date:2019-12-03 Time:09:58
 **/
public class NoVisibility {
    private static boolean ready;
    private static int number;
    private static class ReaderThread extends Thread{
        @Override
        public void run(){
            while (!ready){
                Thread.yield();
            }
            System.out.println(number);
        }
    }

    public static void main(String[] args) {
        new ReaderThread().start();
        number=42;
        ready=true;
    }
}
