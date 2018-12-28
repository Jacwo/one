package com.yyl.one.aop.dao;

import org.springframework.stereotype.Component;

/**
 * @author yyl
 * @date 2018/12/28 22:23
 */
@Component
public class IndexDaoImpl implements IndexDao {

    @Override
    public void query() {
        System.out.println("query");
    }
}
