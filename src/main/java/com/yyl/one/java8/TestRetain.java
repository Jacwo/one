package com.yyl.one.java8;

import java.util.*;

public class TestRetain {
    public static void main(String[] args) {
        Map<String,Object> map=new HashMap();
        map.put("1",1);
        map.put("2",1);
        map.put("3",1);
        List<String> ids=new ArrayList<>();
        ids.add("1");
        ids.add("2");
        ids.add("a");
        Set<String> keys = map.keySet();
        //取交集
        keys.retainAll(ids);
        //此时map里就两个元素
        //        map.put("1",1);
        //        map.put("2",1);

    }
}
