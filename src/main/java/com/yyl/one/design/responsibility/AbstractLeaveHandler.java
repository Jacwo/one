package com.yyl.one.design.responsibility;

/**
 * author:yangyuanliang Date:2020-01-08 Time:16:38
 **/
public abstract class AbstractLeaveHandler {
    protected int min=1;
    protected int mid=3;
    protected int max=30;
    protected String handlerName;
    protected AbstractLeaveHandler nextHandler;
    protected void setNextHandler(AbstractLeaveHandler nextHandler){
        this.nextHandler=nextHandler;
    }
    abstract void handlerRequest(LeaveRequest request);
}
