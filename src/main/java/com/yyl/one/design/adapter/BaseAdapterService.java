package com.yyl.one.design.adapter;

/**
 * 策略
 * @Author:yangyuanliang
 * @Date:2020/5/6 19:16
 * @Description:
 */
public interface BaseAdapterService {
    boolean supports(String serviceName);
    void process();
}
