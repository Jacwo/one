package com.yyl.one.classloder;

/**
 * author:yangyuanliang Date:2019-11-25 Time:17:08
 **/
public class StaticTest {
    public static void main(String[] args) {
        staticFunction();
        StaticTest staticTest=new StaticTest();
    }

    static {
        System.out.println("1");
    }
    {
        System.out.println("2");
    }

    StaticTest(){
        System.out.println("3");
        System.out.println("a="+a+",b="+b);
    }
    public static void staticFunction(){
        System.out.println("4");
    }
    int a=110;
    static int b=112;
}
