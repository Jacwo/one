package com.yyl.one.leetcode;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * author:yangyuanliang Date:2019-11-19 Time:16:43
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 *
 * 示例:
 *
 * 输入: [-2,1,-3,4,-1,2,1,-5,4],
 * 输出: 6
 * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
 **/
public class MaxSubArray {
    public String username;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int maxSubArray(int[] nums) {
        int result=nums[0];
        int sum=0;
        for (int num:nums){
            if(sum<=0){
                sum=num;
            }else{
                sum+=num;
            }
            result=Math.max(result,sum);
        }
        return result;
    }

    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        MaxSubArray maxSubArray = MaxSubArray.class.newInstance();
        Field field=MaxSubArray.class.getField("username");
        field.setAccessible(true);
        Method m = MaxSubArray.class.getMethod("maxSubArray");
        m.setAccessible(true);
        m.invoke(maxSubArray,new int[]{2,32,1});

    }
}
