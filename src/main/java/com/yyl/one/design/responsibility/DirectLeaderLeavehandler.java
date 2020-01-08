package com.yyl.one.design.responsibility;

/**
 * author:yangyuanliang Date:2020-01-08 Time:16:41
 **/
public class DirectLeaderLeavehandler extends AbstractLeaveHandler {

    public DirectLeaderLeavehandler(String name){
        this.handlerName=name;
    }
    @Override
    void handlerRequest(LeaveRequest request) {
        if(request.getLeaveDays()<=this.min){
            System.out.println("直接主管");
            return;
        }
        if(this.nextHandler!=null){
            this.nextHandler.handlerRequest(request);
        }else{
            System.out.println("审批拒绝");
        }
    }
}
