package com.yyl.one.offer;

/**
 * 题目描述
 * 输入一个整数，输出该数二进制表示中1的个数。其中负数用补码表示。
 */
public class Solution10 {
    public static void main(String[] args) {
        int count=0;
        int n=10;
        String s=Integer.toBinaryString(n);
        char ss[]=s.toCharArray();
        for(int i=0;i<ss.length;i++){
            if(ss[i]=='1'){
                count++;
            }
        }
    }
}
