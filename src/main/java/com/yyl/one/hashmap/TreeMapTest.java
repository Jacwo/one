package com.yyl.one.hashmap;

import java.util.*;

/**
 * author:yangyuanliang Date:2019-12-18 Time:10:13
 **/
public class TreeMapTest {
    public static void main(String[] args) {
        Map<String,String> map=new Hashtable<>(5);
        map.put("5","5");
        map.put("1","1");
        map.put("2","2");
        map.put("3","3");
        map.put("4","4");
     //   map.put(null,null);
        for(Map.Entry entry:map.entrySet()){
            System.out.println(entry.getValue());
        }

    }
}
