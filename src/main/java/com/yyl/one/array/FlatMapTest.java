package com.yyl.one.array;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author yangyuanliang
 * @Date 2022/11/30 11:11
 * @Version 2.0
 **/
public class FlatMapTest {
    public static void main(String[] args) {
        //flatMap map
        /**
         * map：map方法返回的是一个object，map将流中的当前元素替换为此返回值；
         *
         * flatMap：flatMap方法返回的是一个stream，flatMap将流中的当前元素替换为此返回流拆解的流元素；
         *
         * 官方解释
         *
         * map:Returns a stream consisting of the results of applying the given function to the elements of this stream.
         *
         * 返回一个流，包含给定函数应用在流中每一个元素后的结果
         *
         * flatmap:Returns a stream consisting of the results of replacing each element of this stream with the contents of a mapped stream produced by applying the provided mapping function to each element.
         *
         * 返回一个流，包含将此流中的每个元素替换为通过给定函数映射应用于每个元素而生成的映射流的内容
         */
        List<List<String>> list1=new ArrayList<>();
        for(int i=0;i<5;i++){
            List<String> list2=new ArrayList<>();
            for(int j=1;j<4;j++){
                list2.add(j+"");
            }
            list1.add(list2);
        }
        System.out.println(list1);
        List<String> collect = list1.stream().flatMap(p -> p.stream()).collect(Collectors.toList());
        System.out.println(collect);
    }
}
