package com.yyl.one.design.strategy;

public class Context {
    private AbstractStrategy abstractStrategy;
    public Context(AbstractStrategy abstractStrategy){
        this.abstractStrategy=abstractStrategy;
    }
    public void exec(){
        abstractStrategy.strategy();
    }
}
