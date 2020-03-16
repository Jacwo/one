package com.yyl.one.java8;





import org.junit.Test;

import java.util.Arrays;
import java.util.stream.Stream;

public class StreamTest {
    //map：转换流，将一种类型的流转换为另外一种流
    @Test
    public void testMap(){
        String arr[]=new String[]{"a","B","c"};
        Arrays.stream(arr).map(x->x.toLowerCase()).forEach(System.out::println);
    }
    //filter：过滤流，过滤流中的元素
    @Test
    public void testFilter(){
        Integer [] integers=new Integer[]{1,2,3,4,5,6,7,8};
        Arrays.stream(integers).filter(x->x>3).forEach(System.out::println);
    }
    //flatMap：拆解流，将流中每一个元素拆解成一个流
    @Test
    public void testFlatMap(){
        String []arr1={"a","b","c","d"};
        String []arr2={"e","f","c","d"};
        String []arr3={"h","j","c","d"};
        Stream.of(arr1,arr2,arr3).flatMap(Arrays::stream).forEach(System.out::print);
    }
}
