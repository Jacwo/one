package com.yyl.one.offer;

/**
 * author:yangyuanliang Date:2019-07-29 Time:16:55
 * 实现函数double Power(double base, int exponent)，
 * 求base的exponent次方。
 **/
public class Solution14 {
    public static double power(double base,int exp){
        if(base==0 && exp==0){
            throw new RuntimeException("input error");
        }

        if(exp==0){
            return 1;
        }
        long exponent=exp;
        if(exponent<0){
            exponent=-exponent;
        }
        double result=powerWithUnsignedExponent(base, exp);
        if(exp<0){
            result=1/result;
        }
        return result;
    }

    private static double powerWithUnsignedExponent(double base, int exp) {
        if(exp==0){
            return 1;
        }
        if(exp==1){
            return base;
        }
        double result=powerWithUnsignedExponent(base,exp>>1);
        result *= result;
        if (exp % 2 != 0) {
            result *= base;
        }

        // 返回结果
        return result;
    }

}
