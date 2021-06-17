package com.yyl.one.leetcode;

/**
 * 给你一个数组 nums 和一个值 val，你需要 原地 移除所有数值等于 val 的元素，并返回移除后数组的新长度。
 *
 * 不要使用额外的数组空间，你必须仅使用 O(1) 额外空间并 原地 修改输入数组。
 *
 * 元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。
 *

 * Created by yyl on 2021/6/17.
 */
public class removeElement {
    public int removeElement(int[] nums, int val) {
        int res = 0;
        for(int i=0; i<nums.length; i++){
            if(nums[i] != val){
                nums[res] = nums[i];
                res ++;
            }
        }
        return res;
    }
    //双指针法
    public int removeElement2(int[] nums, int val) {
        int low=0;
        int fast=0;

        while(fast<nums.length){
            if(nums[fast]!=val){
                nums[low]=nums[fast];
                low++;
            }
            fast++;
        }
        return low;
    }
}
