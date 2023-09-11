package com.yyl.one.spring;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.stereotype.Component;

/**
 * @Author yangyuanliang
 * @Date 2023/9/8 10:00
 * @Version 2.0
 **/
@Slf4j
@Component
public class MyBeanFactoryPostProcessor implements BeanFactoryPostProcessor {
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory configurableListableBeanFactory) throws BeansException {
        BeanDefinition testSpring = configurableListableBeanFactory.getBeanDefinition("testSpring");
        MutablePropertyValues propertyValues = testSpring.getPropertyValues();
        JSONObject.toJSONString(propertyValues);
        log.info("execute BeanFactoryPostProcessor#postProcessBeanFactory");

    }
}
