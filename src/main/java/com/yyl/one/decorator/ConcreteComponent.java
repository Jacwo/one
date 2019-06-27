package com.yyl.one.decorator;


public class ConcreteComponent implements Component {
    {
        System.out.println("具体的组件的代码块");
    }
    public ConcreteComponent(){
        System.out.println("具体的组件构造方法");
    }
    @Override
    public void operation() {
        System.out.println("调用具体构件角色的方法operation()");
    }
}
