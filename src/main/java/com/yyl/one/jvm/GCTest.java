package com.yyl.one.jvm;

import java.util.ArrayList;
import java.util.List;

/**
 * author:yangyuanliang Date:2019-12-28 Time:09:46
 **/
public class GCTest {

    public static void main(String[] args) throws InterruptedException {
        List<byte[]> list=new ArrayList<>();
        list.add(new byte[7*1024*1024]);
        //Thread.sleep(100000);
    }
}
