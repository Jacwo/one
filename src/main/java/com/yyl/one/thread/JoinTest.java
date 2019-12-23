package com.yyl.one.thread;

/**
 * author:yangyuanliang Date:2019-12-23 Time:17:54
 **/
public class JoinTest {
    private class A extends Thread{
        @Override
        public void run() {
            System.out.println("A");
        }
    }

    private class B extends Thread{
        private A a;
        B(A a){
            this.a=a;
        }
        @Override
        public void run() {
            try {
                a.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("B");
        }
    }

    public void test(){
        A a=new A();
        B b=new B(a);
        b.start();
        a.start();
    }

    public static void main(String[] args) {
        JoinTest joinTest=new JoinTest();
        joinTest.test();
    }
}
