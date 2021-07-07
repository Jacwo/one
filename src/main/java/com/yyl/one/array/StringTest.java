package com.yyl.one.array;

public class StringTest {
    public static void main(String[] args) {
        int a=1;
        String s="1";
        String test1="hello word";
        String test4="word";
        String test2="hello "+new String("word");
        String test3="hello "+test1.split(" ")[1];
        String test5="hello "+test4;
        System.out.println(test5.equals(test1));
        System.out.println(test1.equals(test3));
        System.out.println(test1==test2);
        boolean equals = s.equals(a);
       // System.out.println(equals);
    }

}
