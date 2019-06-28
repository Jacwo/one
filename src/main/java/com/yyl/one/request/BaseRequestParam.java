package com.yyl.one.request;

import java.io.Serializable;

/**
 * author:yangyuanliang Date:2019-06-28 Time:10:05
 **/
public class BaseRequestParam<T> implements Serializable {
    private static final long serialVersionUID = 6551333809629423247L;
    private RequestHeader requestHeader;
    private T data;

    public RequestHeader getRequestHeader() {
        return requestHeader;
    }

    public void setRequestHeader(RequestHeader requestHeader) {
        this.requestHeader = requestHeader;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
