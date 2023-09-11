package com.yyl.one.interfaces;

/**
 * @Author yangyuanliang
 * @Date 2023/6/20 16:34
 * @Version 2.0
 **/
public class TestMyInterface {
    public static void main(String[] args) {
        IMyInterface iMyInterface = ()->System.out.println("study");
        iMyInterface.test();
    }
}
