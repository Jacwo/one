package com.yyl.one.pta;

import java.util.Scanner;

/**
 * author:yangyuanliang Date:2019-07-22 Time:17:05
 *
 * 本题要求实现一个函数，求给定的N个整数的和。
 * 其中给定整数存放在数组List[]中，正整数N是数组元素个数。该函数须返回N个List[]元素的和。
 **/
public class Test63 {
    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        System.out.println("请输入整数个数");
        int n=s.nextInt();
        int a[] = new int[n];
        int sum=0;
        for(int i=0;i<n;i++){
            System.out.println("请输入集合整数");
            a[i]=s.nextInt();
            sum+=a[i];
        }
        System.out.println("sum:"+sum);
    }
}
