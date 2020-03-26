package com.yyl.one.design.strategy;

public class Test {


    public static void main(String[] args) {
        new Context(new ConcrateStrategy()).exec();
    }
}
