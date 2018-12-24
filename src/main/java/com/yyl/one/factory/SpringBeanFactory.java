package com.yyl.one.factory;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * ${DESCRIPTION}
 *
 * @author yyl
 * @date 2018年12月20日 15:04
 */
@Component
public class SpringBeanFactory implements ApplicationContextAware,InitializingBean,BeanPostProcessor {
    private ApplicationContext applicationContext;
    private static SpringBeanFactory instance =new SpringBeanFactory();
    public static void setInstance(SpringBeanFactory instance){
        SpringBeanFactory.instance=instance;
    }
    public static SpringBeanFactory getInstance(){
        return SpringBeanFactory.instance;
    }



    public static ApplicationContext getApplicationContext(){
        return getInstance().applicationContext;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        SpringBeanFactory.setInstance(this);
        String[] names = this.applicationContext.getBeanDefinitionNames();
        for (int i = 0; i < names.length; i++) {
            System.out.println(" == names[" + i + "]:" + names[i]);
        }
    }
    /**
     * (non-Javadoc)
     */
    public <T> T getInnerBean(String name, Class<T> targetClass) {
        return (T) this.applicationContext.getBean(name, targetClass);
    }

    /**
     * (non-Javadoc)
     */
    public Object getBean(String name) {
        return this.applicationContext.getBean(name);
    }

    public static <T> T getBean(Class<T> type) {
        return instance.getInnerBean(type);
    }

    public static <T> T getBean(String name , Class<T> type) {
        return instance.getInnerBean(name, type);
    }

    public static <T> Map<String, T> getBeansOfType(Class<T> targetClass) {
        return instance.applicationContext.getBeansOfType(targetClass);
    }

    /**
     * 根据接口获得实体
     */
    @SuppressWarnings("unchecked")
    private <T> T getInnerBean(Class<T> type) {
        String[] names = this.applicationContext.getBeanNamesForType(type);
        if (names == null || names.length == 0) {
            return null;
        }
        return (T) this.applicationContext.getBean(names[0]);
    }
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext=applicationContext;
    }
}
