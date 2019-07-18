package com.yyl.one.design.command;

/**
 * author:yangyuanliang Date:2019-07-18 Time:13:09
 **/
public class ConcreteCommand1 implements Command{
    Receive receive=new Receive();
    @Override
    public void execute() {
        System.out.println("执行命令1");
        receive.action();
    }
}
