package com.yyl.one.thread;

import java.util.Timer;
import java.util.TimerTask;

import static java.util.concurrent.TimeUnit.SECONDS;

/**
 * author:yangyuanliang Date:2020-02-02 Time:16:58
 **/
public class TimerTest {
    public static void main(String[] args) throws InterruptedException {
        Timer timer=new Timer();
        timer.schedule(new Throwtask(),1);
        SECONDS.sleep(1);
        timer.schedule(new Throwtask(),1);
        timer.schedule(new Throwtask(),1);


    }
    static class Throwtask extends TimerTask{
        @Override
        public void run() {
            //try {
                System.out.println("call"+System.currentTimeMillis());
               // SECONDS.sleep(1);
           /* } catch (InterruptedException e) {
                e.printStackTrace();
            }
*/
        }
    }
}
