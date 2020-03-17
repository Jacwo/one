package com.yyl.one.java8;

import org.junit.Before;
import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

public class ParallelStreamTest {
    private Map<Integer,SaveDto> map=new HashMap<>();
    @Before
    public void init(){
        for(int i=0;i<100;i++){

            SaveDto saveDto=new SaveDto();
            saveDto.setNum(getRandom(i));
            saveDto.setIds(initId());
            map.put(i ,saveDto);
        }
    }

    public List<String> initId(){
        List<String> list=new ArrayList<>();
        for(int i=0;i<100000;i++){
            list.add(i+"");
        }
        return list;
    }
    @Test
    public void testParalleStream(){
        testParallelStream();
        testStream();
        testFor();
    }

    public void testParallelStream(){
        long start = System.currentTimeMillis();
        for (Map.Entry<Integer,SaveDto> e:map.entrySet()) {
            List<SaveTest> collect = e.getValue().getIds().parallelStream().map(x -> mergeData(x)).collect(Collectors.toList());
        }
        long end=System.currentTimeMillis();
        System.out.println("paralle耗时"+(end-start)+"ms");
    }


    public void testStream(){
        long start = System.currentTimeMillis();
        for (Map.Entry<Integer,SaveDto> e:map.entrySet()) {
            List<SaveTest> collect = e.getValue().getIds().stream().map(x -> mergeData(x)).collect(Collectors.toList());
        }
        long end=System.currentTimeMillis();
        System.out.println("stream耗时"+(end-start)+"ms");
    }

    public void testFor(){
        List<SaveTest> se=new ArrayList<>();
        long start = System.currentTimeMillis();
        for (Map.Entry<Integer,SaveDto> e:map.entrySet()) {
           for(String s:e.getValue().getIds()){
               SaveTest saveTest=new SaveTest();
               saveTest.setS(s);
               se.add(saveTest);
           }
        }
        long end=System.currentTimeMillis();
        System.out.println("for耗时"+(end-start)+"ms");
    }
    private SaveTest mergeData(String s){
        SaveTest saveTest=new SaveTest();
        saveTest.setS(s);
        return saveTest;
    }
    public int getRandom(int i){
        return (int)(Math.random()*999+i);
    }
}
