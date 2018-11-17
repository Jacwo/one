package com.yyl.one.domain;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * @author yyl
 * @date 2018/11/17 上午11:21
 */
@Setter
@Getter
public class ApiResult implements Serializable {
    private ApiResult(){

    }
    public static ApiResult getInstance(){
        return new ApiResult();
    }
    private String msg;
    private boolean flag=true;
    private Object result;
    private int rows;
    private String jumUrl;
    private long time;
}
