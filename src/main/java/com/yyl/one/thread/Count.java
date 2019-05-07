package com.yyl.one.thread;

public class Count {
    private  static     int counter;

    public static void main(String[] args) {
        Thread thread=new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i=0;i<10;i++){
                    counter++;
                    System.out.println("counter = " + counter);
                }
            }
        });

        Thread thread1=new Thread(new Runnable() {
            @Override
            public void run() {
                for (int j=0;j<10;j++){
                    System.out.println("get count"+counter);

                }
            }
        });
        thread.start();
        thread1.start();

    }
}
