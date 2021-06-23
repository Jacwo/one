package com.yyl.one.leetcode;

/**
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 *
 * 你可以假设数组中无重复元素。
 *
 * 示例 1:
 *
 * 输入: [1,3,5,6], 5
 * 输出: 2
 * Created by yyl on 2021/6/17.
 */
public class searchInsert {
    public int searchInsert(int[] nums, int target) {
        if(target < nums[0]) return 0;
        for(int i=0; i<nums.length; i++){
            if(target <= nums[i])
                return i;
        }
        return nums.length;
    }

    public int searchInsert1(int [] nums, int target){
        int low=0, mid=0, high=nums.length-1;
        while(low<=high){
            mid = (low+high)/2;
            if(target == nums[mid])
                return mid;
            else if(target < nums[mid])
                high = mid-1;
            else
                low = mid+1;
        }
        return low;
    }


    class Solution {
        public int searchInsert(int[] nums, int target) {
            int left=0;
            int right=nums.length-1;
            while(left<right){
                int mid=(left+right)/2;
                if(target>nums[mid]){
                    left=mid+1;
                }else if(target<nums[mid]){
                    right=mid-1;
                }else{
                    return mid;
                }
            }
            return nums[left]>=target ? left:left+1;
        }
    }

    public static void main(String[] args) {
    }
}
