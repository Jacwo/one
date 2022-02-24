package com.yyl.one.design.strategy;

import lombok.AllArgsConstructor;

import java.util.List;
import java.util.Optional;

/**
 * @Author:yangyuanliang
 * @Date:2020/5/6 19:22
 * @Description:
 */
@AllArgsConstructor
public class ServicePlan {
    List<BaseAdapterService> baseAdapterServiceList;
    public Optional<BaseAdapterService> getService(String serviceName){
        if(baseAdapterServiceList.isEmpty()){
            return Optional.empty();
        }
        return  baseAdapterServiceList.stream().filter(p->p.supports(serviceName)).findFirst();
    }
}
