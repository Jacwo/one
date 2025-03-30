package com.yyl.one.collection;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class LinkedListTest {
    LinkedList list =new LinkedList();

    public static void main(String[] args) {
        List<String> strings = Arrays.asList("12", "13");
        //strings.add("333");
       // strings.remove(1);
        String s = strings.get(1);
        System.out.println(s);
    }
}
