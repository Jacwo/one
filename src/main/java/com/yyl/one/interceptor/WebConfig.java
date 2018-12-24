package com.yyl.one.interceptor;


import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.handler.BeanNameUrlHandlerMapping;

/**
 * ${DESCRIPTION}
 *
 * @author yyl
 * @date 2018年12月20日 14:53
 */
@Configuration
public class WebConfig extends WebMvcConfigurationSupport {
    @Override
    protected void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new InterceptorHandler());
        super.addInterceptors(registry);
    }

   /* @Override
    protected void configureViewResolvers(ViewResolverRegistry registry) {
        super.configureViewResolvers(registry);
    }

    @Override
    public BeanNameUrlHandlerMapping beanNameHandlerMapping() {
        return super.beanNameHandlerMapping();
    }*/
}
