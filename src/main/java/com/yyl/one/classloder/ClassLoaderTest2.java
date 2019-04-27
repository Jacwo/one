package com.yyl.one.classloder;

import javax.swing.*;
import java.awt.*;

/**
 * @author yyl
 * @date 2018/11/25 下午4:53
 */
public class ClassLoaderTest2 {
    public static void main(String[] args) {
        Parent2 son=new Son2();
        son=new Son2();
      //  son.
    }
}
class Parent2{
    public static int getI() {
        return i;
    }

    public static void setI(int i) {
        Parent2.i = i;
    }

    private static int i;
    private int j=init();

    private int init() {
        j=99;
        System.out.println("父类初始化");

        return j;
    }

    public int getJ() {
        return j;
    }

    public void setJ(int j) {
        this.j = j;
    }

    static {
        System.out.println("父类静态");
        i=6;
    }
    {
        System.out.println("父类代码快");
        j=77;
        i=7;
    }
    public Parent2(){
        System.out.println("父类构造方法");
        j=88;
        i=8;
    }
}
class Son2 extends Parent2{
    private static int i;
    private int j=init2();

    private int init2() {
        System.out.println("子类初始化");

        return j;
    }

    public static int getI() {
        return i;
    }

    @Override
    public int getJ() {
        return j;
    }

    @Override
    public void setJ(int j) {
        this.j = j;
    }

    public static void setI(int i) {
        Son2.i = i;
    }

    static {
        System.out.println("子类静态");

        i=9;
    }
    {
        System.out.println("子类代码块");

        i=10;
    }
    public Son2(){
        System.out.println("子类构造方法");

        i=11;
    }
}