package com.yyl.one.pta;

import java.util.Scanner;

/**
 * author:yangyuanliang Date:2019-07-22 Time:18:21
 *
 * 本题要求实现一个函数，判断任一给定整数N是否满足条件：它是完全平方数，又至少有两位数字相同，如144、676等。
 **/
public class Test67 {
    public static void main(String[] args) {
        System.out.println("请输入任意整数");
        Scanner s=new Scanner(System.in);
        int n=s.nextInt();
        int hash[]=new int[10];
        double sqrt = Math.sqrt(n);
        if(sqrt*sqrt==n){
            int temp=n;
            while (true){
                if(hash[temp%10]>0)
                    System.out.println("1");
                else
                    ++hash[temp%10];
                temp/=10;
                if(temp==0)
                    break;
            }
            System.out.println("0");
        }
        System.out.println("0");

    }
}
