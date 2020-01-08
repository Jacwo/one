package com.yyl.one.design.responsibility;

/**
 * author:yangyuanliang Date:2020-01-08 Time:16:44
 **/
public class DeptManagerLeaveHandler extends AbstractLeaveHandler {
    public DeptManagerLeaveHandler(String name ){
        this.handlerName=name;
    }
    @Override
    void handlerRequest(LeaveRequest request) {
        if(request.getLeaveDays()>this.min && request.getLeaveDays()<=this.mid){
            System.out.println("部门经理");
            return;
        }
        if(this.nextHandler!=null){
            this.nextHandler.handlerRequest(request);
        }else{
            System.out.println("拒绝");
        }
    }
}
