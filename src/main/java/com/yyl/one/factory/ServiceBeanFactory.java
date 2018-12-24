package com.yyl.one.factory;

import com.yyl.one.service.IUserService;
import lombok.Getter;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

/**
 * ${DESCRIPTION}
 *
 * @author yyl
 * @date 2018年12月20日 17:28
 */
@Service
@Getter
public class ServiceBeanFactory {

    private IUserService  userService;
    @PostConstruct
    public void init(){
        this.userService=ServiceFactory.createService(IUserService.class);
    }
}
