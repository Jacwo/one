package com.yyl.one.design.responsibility;

/**
 * author:yangyuanliang Date:2020-01-08 Time:16:46
 **/
public class GManagerLeaveHandler extends AbstractLeaveHandler {
    public GManagerLeaveHandler(String name){
        this.handlerName=name;
    }
    @Override
    void handlerRequest(LeaveRequest request) {
        if(request.getLeaveDays()>this.mid && request.getLeaveDays()<=this.max){
            System.out.println("总经理");
            return;
        }
        if(this.nextHandler!=null){
            this.nextHandler.handlerRequest(request);
        }else{
            System.out.println("审批拒绝");
        }
    }
}
