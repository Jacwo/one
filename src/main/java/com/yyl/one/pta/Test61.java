package com.yyl.one.pta;

import java.util.Scanner;

/**
 * author:yangyuanliang Date:2019-07-22 Time:10:02
 * 本题要求实现一个函数，对给定的正整数N，打印从1到N的全部正整数。
 **/
public class Test61 {
    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        System.out.println("请输入整数");
        Integer input=s.nextInt();
        for (int i=1;i<=input;i++){
            System.out.println(i);
        }
    }
}
