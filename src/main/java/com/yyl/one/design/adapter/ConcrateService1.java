package com.yyl.one.design.adapter;

/**
 * @Author:yangyuanliang
 * @Date:2020/5/6 19:17
 * @Description:
 */
public class ConcrateService1 implements BaseAdapterService {
    @Override
    public boolean supports(String serviceName) {
        return "concrate1".equals(serviceName);
    }

    @Override
    public void process() {
        System.out.println("concrate1 process");
    }
}
