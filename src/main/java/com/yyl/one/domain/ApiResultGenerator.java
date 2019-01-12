/*
package com.yyl.one.domain;

import java.util.List;

*/
/**
 * @author yyl
 * @date 2018/11/17 上午11:26
 *//*

public final class ApiResultGenerator {

    public static ApiResult result (boolean flag,String msg,Object result,String jumpUrl,int rows,Throwable throwable){
        ApiResult apiResult=ApiResult.getInstance();
        apiResult.setFlag(flag);
        apiResult.setJumUrl(jumpUrl);
        apiResult.setResult(result);
        apiResult.setMsg(msg);
        apiResult.setRows(rows);
        apiResult.setTime(System.currentTimeMillis());
        return apiResult;
    }

    public static ApiResult successResult(Object result){
        int rows=0;
        if(result instanceof List){
            rows=((List) result).size();
        }
        return result(true,"",result,"",rows,null);
    }

    public static ApiResult errorResult(String message, Exception e) {
        return result(false,message,"","",0,e);
    }
}
*/
