package com.yyl.one.collection;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class CollectTest2{
    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        arrayList.add(-1);
        arrayList.add(3);
        arrayList.add(3);
        arrayList.add(-5);
        arrayList.add(7);
        arrayList.add(4);
        arrayList.add(-9);
        arrayList.add(-7);
        ArrayList<Integer> arrayList2 = new ArrayList<>();
        arrayList2.add(-3);
        arrayList2.add(-5);
        arrayList2.add(7);
        ArrayList<Integer> integers = new ArrayList<>(arrayList2);
        integers.stream().forEach(integer -> System.out.println(integer));
        ConcurrentHashMap concurrentHashMap=new ConcurrentHashMap();
       // concurrentHashMap.put(null,null);

        Map map=new HashMap();
        map.put(null,null);
        System.out.println(32-(32>>>2));


        System.out.println("原始数组:");
        System.out.println(arrayList);

        System.out.println("Collections.max(arrayList):");
        System.out.println(Collections.max(arrayList));

        System.out.println("Collections.min(arrayList):");
        System.out.println(Collections.min(arrayList));

        System.out.println("Collections.replaceAll(arrayList, 3, -3):");
        Collections.replaceAll(arrayList, 3, -3);
        System.out.println(arrayList);

        System.out.println("Collections.frequency(arrayList, -3):");
        System.out.println(Collections.frequency(arrayList, -3));

        System.out.println("Collections.indexOfSubList(arrayList, arrayList2):");
        System.out.println(Collections.indexOfSubList(arrayList, arrayList2));

        System.out.println("Collections.binarySearch(arrayList, 7):");
        // 对List进行二分查找，返回索引，List必须是有序的
        Collections.sort(arrayList);
        System.out.println(Collections.binarySearch(arrayList, 7));
    }
}