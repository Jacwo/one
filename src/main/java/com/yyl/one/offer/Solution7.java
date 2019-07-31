package com.yyl.one.offer;

/**
 * 题目描述
 * 大家都知道斐波那契数列，现在要求输入一个整数n，
 * 请你输出斐波那契数列的第n项（从0开始，第0项为0）。
 * F(1)=1，
 * F(2)=1,
 * F(n)=F(n-1)+F(n-2)（n>=3，n∈N*）
 * n<=39
 */
public class Solution7 {
    public int Fibonacci(int n) {
        int a=1,b=1,c=0;
        if(n<0){
            return 0;
        }else if(n==1||n==2){
            return 1;
        }else{
            for(int i=3;i<=n;i++){
                c=a+b;
                b=a;
                a=c;
            }
            return c;
        }

    }
}
