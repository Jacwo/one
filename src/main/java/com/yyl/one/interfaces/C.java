package com.yyl.one.interfaces;

/**
 * @Author:yangyuanliang
 * @Date:2020/5/22 14:21
 * @Description:
 */
public class C implements A,B {
    @Override
    public void a() {
        System.out.println("ssss");
    }

    public static void main(String[] args) {
        C a=new C();
        a.a();
    }
}
