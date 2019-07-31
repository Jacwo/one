package com.yyl.one.controller;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * author:yangyuanliang Date:2019-07-30 Time:11:45
 **/
public class Test {
    public static final String process(String processUrl) throws Exception {
        InputStreamReader isr = null;
        BufferedReader inReader = null;
        StringBuffer result = null;
        OutputStream outObject = null;

        try {
            URL url = new URL(processUrl);
            HttpURLConnection httpConn = (HttpURLConnection)url.openConnection();
            //httpConn.setRequestProperty("ksname","周瑞鹏");
            //httpConn.setRequestProperty("idnumber","412724200008086931");

            httpConn.setRequestProperty("Content-Length", "95");
            httpConn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded; charset=UTF-88");
            httpConn.setRequestMethod("POST");
            httpConn.setDoOutput(true);
            httpConn.setDoInput(true);
            StringBuffer params = new StringBuffer();
            // 表单参数与get形式一样
            params.append("ksname").append("=").append("周瑞鹏").append("&")
                    .append("idnumber").append("=").append("412724200008086931");
            byte[] bypes = params.toString().getBytes();
            httpConn.getOutputStream().write(bypes);// 输入参数
            if (200 != httpConn.getResponseCode()) {
                throw new Exception("HTTP Request is not success, Response code is " + httpConn.getResponseCode());
            } else {
                isr = new InputStreamReader(httpConn.getInputStream(), "utf-8");
                inReader = new BufferedReader(isr);
                result = new StringBuffer();

                String inputLine;
                while((inputLine = inReader.readLine()) != null) {
                    result.append(inputLine);
                }

                String var9 = result.toString();
                return var9;
            }
        } catch (IOException var13) {
            throw var13;
        } finally {
            if (inReader != null) {
                inReader.close();
            }

            if (isr != null) {
                isr.close();
            }

            if (outObject != null) {
                outObject.close();
            }

        }
    }
    public static void main(String[] args) {
        int i=0;
        try {
            while (true){
                String s=process("http://wzs.wfust.edu.cn/index.php?s=/Home/Sign/seach.html");
                if(s.contains("false")){
                    i++;
                    System.out.println("第"+i+"次查询----未查询到");
                    System.out.println("正在休眠....");

                }else{
                    System.out.println(s);
                }

                Thread.sleep(10000);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
