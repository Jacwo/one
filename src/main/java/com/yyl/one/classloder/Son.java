package com.yyl.one.classloder;

/**
 * author:yangyuanliang Date:2019-11-26 Time:11:27
 *
 *
 * parent before sing
 * son sing age0
 * parent after sing
 * son age10
 *
 *
 **/
public class Son extends Parent {
    private int age =1;
    public Son(int age){
        this.age=age;
        System.out.println("son age"+age);
    }
    @Override
    void sing(){
        System.out.println("son sing age"+age);
    }


    public static void main(String[] args) {
        new Son(10);
    }
}
