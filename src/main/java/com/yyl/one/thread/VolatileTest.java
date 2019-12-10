package com.yyl.one.thread;

/**
 * author:yangyuanliang Date:2019-12-09 Time:17:56
 **/
public class VolatileTest {
    public static void main(String[] args) {
        MyThread myThread=new MyThread();
        new Thread(myThread).start();
        while (true){
            synchronized (myThread){
                if(myThread.isFlag()){
                    System.out.println("flag被设置为true");
                    break;
                }
            }
        }
    }

   static class MyThread implements Runnable{
        private volatile  boolean flag=false;
        public boolean isFlag(){
            return flag;
        }
        public void setFlag(boolean flag){
            this.flag=flag;
        }
        @Override
        public void run() {
            try {
                Thread.sleep(200);
            }catch (Exception e){
                e.printStackTrace();
            }
            flag=true;
            System.out.println("flag"+flag);
        }
    }
}
