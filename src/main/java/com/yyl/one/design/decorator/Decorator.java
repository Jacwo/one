package com.yyl.one.design.decorator;

/**
 * author:yangyuanliang Date:2019-06-27 Time:14:00
 **/
public class Decorator implements Component {
    private Component component;
    public Decorator(Component component){
        this.component=component;
    }
    @Override
    public void operation() {
        component.operation();
    }
}
