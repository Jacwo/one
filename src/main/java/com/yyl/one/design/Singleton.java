package com.yyl.one.design;

import java.security.PrivateKey;

/**
 * author:yangyuanliang Date:2019-12-19 Time:16:09
 * 问题：为什么需要两次判断if(singleTon==null)?
 *
 * 　　分析：第一次校验：由于单例模式只需要创建一次实例，如果后面再次调用getInstance方法时，
 * 则直接返回之前创建的实例，因此大部分时间不需要执行同步方法里面的代码，大大提高了性能。
 * 如果不加第一次校验的话，那跟上面的懒汉模式没什么区别，每次都要去竞争锁。
 *
 * 　　　　 第二次校验：如果没有第二次校验，假设线程t1执行了第一次校验后，判断为null，
 * 这时t2也获取了CPU执行权，也执行了第一次校验，判断也为null。接下来t2获得锁，创建实例。
 * 这时t1又获得CPU执行权，由于之前已经进行了第一次校验，结果为null（不会再次判断），
 * 获得锁后，直接创建实例。结果就会导致创建多个实例
 * 。所以需要在同步代码里面进行第二次校验，如果实例为空，则进行创建。
 *
 * 　　需要注意的是，private static volatile SingleTon3 singleTon=null;需要加volatile关键字，否则会出现错误。问题的原因在于JVM指令重排优化的存在。在某个线程创建单例对象时，在构造方法被调用之前，就为该对象分配了内存空间并将对象的字段设置为默认值。此时就可以将分配的内存地址赋值给instance字段了，然而该对象可能还没有初始化。若紧接着另外一个线程来调用getInstance，取到的就是状态不正确的对象，程序就会出错。
 **/
public class Singleton {
    private Singleton(){

    }
    private static volatile  Singleton singleton=null;
    public static Singleton getInstance(){
        if(singleton==null){
            synchronized (Singleton.class){
                if(singleton==null){
                    singleton=new Singleton();
                }
            }
        }
        return singleton;
    }

}
