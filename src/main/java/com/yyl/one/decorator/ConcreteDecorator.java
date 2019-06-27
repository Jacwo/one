package com.yyl.one.decorator;


public class ConcreteDecorator  extends Decorator {


    public ConcreteDecorator(Component component) {
        super(component);
    }
    public void operation(){
        super.operation();
        addFunction();
    }

    private void addFunction() {
        System.out.println("为具体构件角色增加额外的功能addedFunction()");
    }
}
