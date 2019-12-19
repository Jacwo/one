package com.yyl.one.abstracc;

/**
 * author:yangyuanliang Date:2019-12-19 Time:10:27
 **/
public class TestInterfaceImpl implements InterfaceTest {
    @Override
    public void foo() {
        System.out.println("foo");
    }

    @Override
    public void foo2() {
        System.out.println("foo2");
    }
}
