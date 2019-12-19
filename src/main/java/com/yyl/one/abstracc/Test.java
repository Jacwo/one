package com.yyl.one.abstracc;

/**
 * author:yangyuanliang Date:2019-12-19 Time:10:19
 **/
public class Test {
    public static void main(String[] args) {
        AbstractTest abstractTest=new Con();
        abstractTest.foo();
        abstractTest.a();
        AbstractTest.foor();

        InterfaceTest interfaceTest=new TestInterfaceImpl();
        interfaceTest.foo();
        interfaceTest.foo2();
    }
}
