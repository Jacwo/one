package com.yyl.one.Factory;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * ${DESCRIPTION}
 *
 * @author yyl
 * @date 2018年12月20日 15:01
 */

public class ServiceFactory {
    private static volatile boolean initialized;
    private static ApplicationContext applicationContext;
    private static void init(){
        if(applicationContext==null){
            applicationContext=SpringBeanFactory.getApplicationContext();
            if(applicationContext==null){
                applicationContext=new ClassPathXmlApplicationContext("spring/application.xml");
            }
            initialized=true;
        }
    }


    /**
     * 返回服务类对象
     *
     * @param serviceType
     * @param name
     * @return
     */
    public synchronized static <T> T createService(Class<T> serviceType, String name, String serverUrl, int timeout) {
        if (serviceType == null) {
            throw new IllegalArgumentException("argment 'serviceType' cannot be null");
        }
        if (!initialized) {
            init();
        }
        T service = null;
        if (name == null) {
            service = SpringBeanFactory.getBean(serviceType);
        } else {
            service = SpringBeanFactory.getBean(name, serviceType);
        }

        return service;
    }

    public synchronized static <T> T createService(Class<T> serviceType, String name) {
        return createService(serviceType, name, null, 0);
    }

    public static <T> T createService(Class<T> serviceType) {
        return createService(serviceType, null);
    }
}
