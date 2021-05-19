package com.yyl.one.leetcode;

/**
 * Created by yyl on 2020/12/10
 * 给定一个二进制数组， 计算其中最大连续1的个数。
 *
 * 示例 1:
 *
 * 输入: [1,1,0,1,1,1]
 * 输出: 3
 * 解释: 开头的两位和最后的三位都是连续1，所以最大连续1的个数是 3.
 * 注意：
 *
 * 输入的数组只包含 0 和1。
 * 输入数组的长度是正整数，且不超过 10,000。
 */
public class findMaxConsecutiveOnes {
    public int findMaxConsecutiveOnes(int[] nums) {
        int left = 0, max = 0, i=0;
        for(i=0; i<nums.length; i++){
            if(nums[i] == 0) {
                max = Math.max(i - left, max);
                left = i+1;
            }
        }
        return Math.max(max, i-left);
    }

    public int findMaxConsecutiveOnes1(int[] nums) {
        int maxSum = 0, sum = 0;
        for (int n : nums) {
            sum *= n;
            sum += n;
            maxSum = Math.max(maxSum, sum);
        }
        return maxSum;
    }
}
