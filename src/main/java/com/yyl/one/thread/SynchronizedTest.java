package com.yyl.one.thread;

public class SynchronizedTest {

    public  static synchronized void add() throws InterruptedException {
        System.out.println("add");
        Thread.sleep(100000);
    }

    public  static synchronized void add2(){
        System.out.println("add2");
    }

    public static void main(String[] args) throws InterruptedException {
      //  SynchronizedTest synchronizedTest=new SynchronizedTest();

      //  SynchronizedTest.add();
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true){
                    SynchronizedTest.add2();
                }

            }
        }).start();

    }

}
