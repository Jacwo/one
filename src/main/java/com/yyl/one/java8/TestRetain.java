package com.yyl.one.java8;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TestRetain {
    public static void main(String[] args) {
      /*  Map<String,Object> map=new HashMap();
        map.put("1",1);
        map.put("2",1);
        map.put("3",1);*/
        List<String> list2 = Arrays.asList("hello", "hi", "你好");
        List<String> list3 = Arrays.asList("zhangsan", "lisi", "wangwu", "zhaoliu");

        list2.stream().map(item -> list3.stream().map(item2 -> item + " " + item2)).collect(Collectors.toList()).forEach(System.out::println);
        list2.stream().flatMap(item -> list3.stream().map(item2 -> item + " " + item2)).collect(Collectors.toList()).forEach(System.out::println);

        //实际上返回的类似是不同的
        List<Stream<String>> list2Result = list2.stream().map(item -> list3.stream().map(item2 -> item + " " + item2)).collect(Collectors.toList());
        List<String> list2Result2 = list2.stream().flatMap(item -> list3.stream().map(item2 -> item + " " + item2)).collect(Collectors.toList());


        /* Set<String> keys = map.keySet();
        //取交集
        keys.retainAll(ids);*/
        //此时map里就两个元素
        //        map.put("1",1);
        //        map.put("2",1);

    }

    private static TestFlatMap mergeData(String p) {
        TestFlatMap testFlatMap = new TestFlatMap();
        testFlatMap.setId(p);
        return testFlatMap;
    }
}
