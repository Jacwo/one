package com.yyl.one.design.adapter;

/**
 * @Author:yangyuanliang
 * @Date:2020/5/6 19:17
 * @Description:
 */
public class ConcrateService2 implements BaseAdapterService {
    @Override
    public boolean supports(String serviceName) {
        return "concrate2".equals(serviceName);
    }

    @Override
    public void process() {
        System.out.println("concrate2 process");

    }
}
