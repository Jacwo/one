package com.yyl.one.leetcode;

import java.util.Arrays;

/**
 * Created by yyl on 2020/12/07
 * 数组拆分，使得 max(sum)=min(Ai,Bi)的总和最大
 * [1,4,3,2]
 * n=4 sum=4
 * 4=min(1,2)+min(3,4)
 * 解题思路
 * 先排序，然后把所有奇数位置的元素相加
 *
 */
public class arrayPairSum {
    public int arrayPairSum(int[] nums) {
        //数组排序
        Arrays.sort(nums);
        int sum = 0;
        for(int i=0; i<nums.length; i+=2){
            //对所有奇数位置元素求和
            sum += nums[i];
        }
        return sum;
    }
}
