package com.yyl.one.leetcode;

import java.util.Arrays;

/**
 * 给定一个包含 [0, n] 中 n 个数的数组 nums ，找出 [0, n] 这个范围内没有出现在数组中的那个数。
 *
 *  
 *
 * 进阶：
 *
 * 你能否实现线性时间复杂度、仅使用额外常数空间的算法解决此问题?
 *  
 *
 * 示例 1：
 *
 * 输入：nums = [3,0,1]
 * 输出：2
 * 解释：n = 3，因为有 3 个数字，所以所有的数字都在范围 [0,3] 内。2 是丢失的数字，因为它没有出现在 nums 中。

 * Created by yyl on 2021/5/27.
 */
public class missingNumber {
    public int missingNumber(int[] nums) {
        Arrays.sort(nums);
        for(int i=0; i<nums.length; i++)
        {
            if(nums[i] != i)
                return i;
        }
        return nums.length;
    }

    public int missingNumber0(int[] nums) { //binary search
        Arrays.sort(nums);
        int left = 0, right = nums.length, mid= (left + right)/2;
        while(left<right){
            mid = (left + right)/2;
            if(nums[mid]>mid) right = mid;
            else left = mid+1;
        }
        return left;
    }

    public int missingNumber1(int[] nums){
        int sum = 0;
        for(int num : nums){
            sum += num;
        }
        return nums.length*(nums.length+1)/2 - sum;
    }

    public int missingNumber2(int[] nums) {
        //a^b^b=a。所以本例中可以使用异或操作
        int xor = 0, i = 0;
        for (i = 0; i < nums.length; i++) {
            xor = xor ^ i ^ nums[i];
        }

        return xor ^ i;
    }

    //先算前n项和，然后在减
    public int missingNumber3(int[] nums) {
        int count=((nums.length+1)*nums.length)/2;
        for(int i:nums){
            count-=i;
        }
        return count;

    }

    public static void main(String[] args) {
        int a[]={9,6,4,2,3,5,7,0,1};
    }
}
