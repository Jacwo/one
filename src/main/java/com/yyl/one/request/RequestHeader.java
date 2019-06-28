package com.yyl.one.request;

import java.io.Serializable;

/**
 * author:yangyuanliang Date:2019-06-28 Time:10:08
 * method
 * timestamp
 * version
 * org_type
 * org_id
 * req_seq
 * operator_id
 * code
 * msg
 * xtbl
 **/
public class RequestHeader implements Serializable {
    private String method;
    private String timestamp;
    private String version;
    private String org_type;
    private String org_id;
    private String req_seq;
    private String operator_id;
    private String code;
    private String msg;
    private String xtbl;

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getOrg_type() {
        return org_type;
    }

    public void setOrg_type(String org_type) {
        this.org_type = org_type;
    }

    public String getOrg_id() {
        return org_id;
    }

    public void setOrg_id(String org_id) {
        this.org_id = org_id;
    }

    public String getReq_seq() {
        return req_seq;
    }

    public void setReq_seq(String req_seq) {
        this.req_seq = req_seq;
    }

    public String getOperator_id() {
        return operator_id;
    }

    public void setOperator_id(String operator_id) {
        this.operator_id = operator_id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getXtbl() {
        return xtbl;
    }

    public void setXtbl(String xtbl) {
        this.xtbl = xtbl;
    }
}
