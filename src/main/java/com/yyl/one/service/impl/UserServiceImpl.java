package com.yyl.one.service.impl;

import com.yyl.one.service.IUserService;
import org.springframework.stereotype.Service;

/**
 * ${DESCRIPTION}
 *
 * @author yyl
 * @date 2018年12月20日 17:32
 */
@Service
public class UserServiceImpl implements IUserService {
    @Override
    public void login() {
        System.out.println("login ...");
    }
}
