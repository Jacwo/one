package com.yyl.one.pta;

import java.util.Scanner;

/**
 * author:yangyuanliang Date:2019-07-22 Time:18:52
 *
 * 本题要求实现一个函数，可统计任一整数中某个位数出现的次数。例如-21252中，2出现了3次，则该函数应该返回3。
 **/
public class Test69 {
    public static void main(String[] args) {
        System.out.println("请输入任意整数");
        Scanner s=new Scanner(System.in);
        int n=s.nextInt();
        int a[]=new int[10];
        System.out.println("请输入任意[0, 9]区间内的个位数");
        int x=s.nextInt();
        int temp=n;

        while (true){
            if(temp%10==x){
               a[n%10]++;
            }
            temp=temp/10;
            if(temp==0){
                break;
            }
        }
        for(int i=0;i<10;i++){
            if(a[i]>0){
                System.out.println(a[i]);
            }
        }

    }
}
