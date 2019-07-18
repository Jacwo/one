package com.yyl.one.design.command;

/**
 * author:yangyuanliang Date:2019-07-18 Time:13:07
 **/
public class Invoker {
    private Command command;
    public Invoker(Command command){
        this.command=command;
    }
    public void call(){
        command.execute();
    }
}
