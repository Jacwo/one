package com.yyl.one.classloder;

/**
 * author:yangyuanliang Date:2019-11-26 Time:11:26
 **/
public class Parent {
    public Parent(){
        System.out.println("parent before sing");
        sing();
        System.out.println("parent after sing");

    }
    void sing(){
        System.out.println("parent sing");
    }


}
