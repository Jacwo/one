package com.yyl.one.leetcode;

/**
 * 给定一个含有 n 个正整数的数组和一个正整数 target 。
 *
 * 找出该数组中满足其和 ≥ target 的长度最小的 连续子数组 [numsl, numsl+1, ..., numsr-1, numsr] ，并返回其长度。如果不存在符合条件的子数组，返回 0 。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：target = 7, nums = [2,3,1,2,4,3]
 * 输出：2
 * 解释：子数组 [4,3] 是该条件下的长度最小的子数组。
 *

 * Created by yyl on 2021/5/28.
 */
public class minSubArrayLen {
    public int minSubArrayLen(int s, int[] nums) {

        int left=0, sum=0, min = Integer.MAX_VALUE;

        for(int i=0; i<nums.length; i++){
            sum += nums[i];
            while(sum >= s) {
                min = Math.min(min, i - left + 1);
                sum -= nums[left++];
            }
        }
        if(min == Integer.MAX_VALUE)
            return 0;
        return min ;
    }
    public int minSubArrayLen3(int target, int[] nums) {
        int length = nums.length;
        int left = 0;   // 左指针
        int right = 0;  // 右指针

        int count = 0;               // 总数，用于比较目标值
        int min = Integer.MAX_VALUE; // 最小区间
        while (right < length) {
            count += nums[right++];
            while (count >= target) {
                min = Math.min(min, right - left);
                count -= nums[left++];
            }
        }
        return min == Integer.MAX_VALUE ? 0 : min;
    }


    public int minSubArrayLen2(int target, int[] nums) {
        int min=Integer.MAX_VALUE;
        int sum=0;
        boolean flag=false;
        for(int i=0;i<nums.length;i++){
            sum=0;
            if(nums[i]>=target ) return 1;
            for(int j=i;j<nums.length;j++){
                sum=nums[j]+sum;
                if(sum>=target){
                    min=Math.min(min,j-i+1);
                    flag=true;
                    break;
                }
            }
        }
        if(!flag) return 0;
        return min;
    }

}
