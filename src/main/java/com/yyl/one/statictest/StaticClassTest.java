package com.yyl.one.statictest;

public class StaticClassTest {

    static class InnerClass{
        private String a;
        static int b=0;
        public String getA() {
            return a;
        }

        public void setA(String a) {
            this.a = a;
        }
    }
    public static void main(String[] args) {
        InnerClass innerClass=new StaticClassTest.InnerClass();
    }
}
