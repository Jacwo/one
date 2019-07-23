package com.yyl.one.pta;

import java.util.Scanner;

/**
 * author:yangyuanliang Date:2019-07-22 Time:10:04
 * 本题要求实现一个函数，计算阶数为n，系数为a[0] ... a[n]的多项式f(x)=∑
 * ​i=0-​n
 * ​​ (a[i]×x的i次方) 在x点的值。
 *
 *
 *x=1 n=3
 * f(1)=a[0]+1l0+a[1]+1l1
 **/
public class Test62 {
    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        System.out.println("请输入多项式阶数");
        Integer n=s.nextInt();
        System.out.println("请输入定点");
        Double x=s.nextDouble();
        double a[] = new double[n+1];
        for (int i=0;i<=n;i++){
            System.out.println("请输入系数");
            Double kk=s.nextDouble();
            a[i]=kk;
        }
        System.out.println(f(n,a,x));


    }
    public static double f(int n,double a[],double x){
        double sum=a[0];
        double b=1;
        for (int i=1;i<=n;i++){
            b=b*x;
            sum=sum+b*a[i];
        }
        return sum;
    }
}
