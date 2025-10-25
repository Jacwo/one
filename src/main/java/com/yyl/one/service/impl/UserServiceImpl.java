package com.yyl.one.service.impl;

import com.yyl.one.service.IUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * ${DESCRIPTION}
 *
 * @author yyl
 * @date 2018年12月20日 17:32
 */
@Service
@Slf4j
public class UserServiceImpl implements IUserService {

    @Autowired
    private RestTemplate restTemplate;
    @Override
    public void login() {
        log.info("Getting user with id: {}", 1);

        ResponseEntity<String> response = restTemplate.getForEntity(
                "http://localhost:8080/profiles/" + 1, String.class);

        log.info("Called profile service for user: {}", 1);
        System.out.println("login ...");
    }
}
