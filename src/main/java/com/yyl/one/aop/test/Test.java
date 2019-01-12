package com.yyl.one.aop.test;

import com.yyl.one.aop.config.AppConfig;
import com.yyl.one.aop.dao.IndexDao;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author yyl
 * @date 2018/12/28 22:23
 */
public class Test {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext=new AnnotationConfigApplicationContext(AppConfig.class);
        IndexDao indexdao=applicationContext.getBean(IndexDao.class);
        indexdao.query();
    }
}
