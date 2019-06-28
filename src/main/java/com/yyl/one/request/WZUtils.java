package com.yyl.one.request;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * author:yangyuanliang Date:2019-06-28 Time:11:19
 **/
public class WZUtils {
    private static String version="1.0";
    private static String orgId="0000000181";
    private static String pattern1="yyyyMMdd/HHmmss/";
    private static String pattern2="yyyyMMddhh24miss";
    public static RequestHeader generateHeader(String method,String orgType,String operationId) {
        RequestHeader requestHeader=new RequestHeader();
        requestHeader.setMethod(method);
        requestHeader.setVersion(version);
        requestHeader.setOrg_type(orgType);
        requestHeader.setOrg_id(orgId);
         requestHeader.setTimestamp(getCurrentTimestamp(pattern1));
        //requestHeader.setReq_seq();
        requestHeader.setOperator_id(operationId);
        return requestHeader;
    }

    public static String getCurrentTimestamp(String pattern){
        Date date=new Date();
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat(pattern);
        String format = simpleDateFormat.format(date);
        return format;
    }

    //private static String get

   /* public static String generateReqSeq(){
        return orgId.substring(0,10)+getCurrentTimestamp(pattern2)+ UUID.randomUUID().toString().replace("")
    }*/


    public static void main(String[] args) {
       // System.out.println(getCurrentTimestamp());
    }
}
