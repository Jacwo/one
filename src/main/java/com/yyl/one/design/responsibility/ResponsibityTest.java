package com.yyl.one.design.responsibility;

/**
 * author:yangyuanliang Date:2020-01-08 Time:16:48
 **/
public class ResponsibityTest {
    public static void main(String[] args) {
        LeaveRequest request=new LeaveRequest();
        request.setLeaveDays(1);
        request.setName("test");
        AbstractLeaveHandler direct=new DirectLeaderLeavehandler("直属上级");
        DeptManagerLeaveHandler deptManagerLeaveHandler=new DeptManagerLeaveHandler("部门");
        GManagerLeaveHandler gManagerLeaveHandler=new GManagerLeaveHandler("总经理");
        direct.setNextHandler(deptManagerLeaveHandler);
        deptManagerLeaveHandler.setNextHandler(gManagerLeaveHandler);
        direct.handlerRequest(request);
    }
}
