package com.yyl.one.collection;



import org.apache.commons.collections.CollectionUtils;

import java.util.*;
import java.util.stream.Collectors;

public class CollectionTest {
    public static void main(String[] args) {
        Set<String> set=new HashSet<>();
        set.add("EMAIL");
        set.add("NAME");
        Set<String> set2=new HashSet<>();
        set2.add("EMAIL");
       // set2.add("NAME");
        Collection<String> intersection = CollectionUtils.intersection(set, set2);
        System.out.println(intersection);
        System.out.println("-------------------------------");
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        arrayList.add(-1);
        arrayList.add(3);
        arrayList.add(3);
        arrayList.add(-5);
        arrayList.add(7);
        arrayList.add(4);
        arrayList.add(-9);
        arrayList.add(-7);
        System.out.println("原始数组:");
        System.out.println(arrayList);
        // void reverse(List list)：反转
        Collections.reverse(arrayList);
        System.out.println("Collections.reverse(arrayList):");
        System.out.println(arrayList);


        Collections.rotate(arrayList, 4);
        System.out.println("Collections.rotate(arrayList, 4):");
        System.out.println(arrayList);

        // void sort(List list),按自然排序的升序排序
        Collections.sort(arrayList);
        System.out.println("Collections.sort(arrayList):");
        System.out.println(arrayList);

        // void shuffle(List list),随机排序
        Collections.shuffle(arrayList);
        System.out.println("Collections.shuffle(arrayList):");
        System.out.println(arrayList);

        // void swap(List list, int i , int j),交换两个索引位置的元素
        Collections.swap(arrayList, 2, 5);
        System.out.println("Collections.swap(arrayList, 2, 5):");
        System.out.println(arrayList);
        List list=new ArrayList();
        Collections.synchronizedMap(new HashMap<>());
        List list1 = Collections.synchronizedList(list);
        // 定制排序的用法
        Collections.sort(arrayList, new Comparator<Integer>() {

            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(o2);
            }
        });
        System.out.println("定制排序后：");
        System.out.println(arrayList);

        Map map=new HashMap(1);
        map.put("1","1");

        map.put("2","2");
        map.put("3","3");

        map.put("4","5");
        Collections.synchronizedList(list);
    }

}
