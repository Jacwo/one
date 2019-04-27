package com.yyl.one.java8;

import java.util.*;

public class Lamdom {
    public static void main(String[] args) throws InterruptedException {
        List<String> list=new ArrayList<>();
        Map<String,Object> map=new HashMap<>();
        map.put(Color.RED.getName(),Color.RED.getValue());
        map.put(Color.YELLOW.getName(),Color.YELLOW.getValue());
        map.put(Color.GREEN.getName(),Color.GREEN.getValue());
        for(Map.Entry key:map.entrySet()){
            list.add((String) key.getKey());
        }
        Thread.sleep(90000);

        list.stream().filter(e->e.equals("red")).forEach(e-> System.out.println("args = [" + e + "]"));
        list.stream().forEach(e-> System.out.println("args = [" + e + "]"));
       // Iterable it=list.iterator();
        //遍历元素需要删除使用迭代器
       // Integer.
        for(Iterator<String> it=list.iterator();it.hasNext();){
            String a=it.next();
            if(Color.RED.getName().equals(a)){
                it.remove();


            }
            //System.out.println("it.next() = " + a);
        }
        for (String s:list){
            System.out.println("s = " + s);
        }
     //   list.stream().
    }
}
