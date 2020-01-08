package com.yyl.one.design.responsibility;

import lombok.*;

/**
 * author:yangyuanliang Date:2020-01-08 Time:16:37
 **/

public class LeaveRequest {
    private int leaveDays;
    private String name;

    public int getLeaveDays() {
        return leaveDays;
    }

    public void setLeaveDays(int leaveDays) {
        this.leaveDays = leaveDays;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
