package com.yyl.one.leetcode;

/**
 * 给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。
 *
 *  
 *
 * 进阶：
 *
 * 尽可能想出更多的解决方案，至少有三种不同的方法可以解决这个问题。
 * 你可以使用空间复杂度为 O(1) 的 原地 算法解决这个问题吗？
 *  
 *
 * 示例 1:
 *
 * 输入: nums = [1,2,3,4,5,6,7], k = 3
 * 输出: [5,6,7,1,2,3,4]
 * 解释:
 * 向右旋转 1 步: [7,1,2,3,4,5,6]
 * 向右旋转 2 步: [6,7,1,2,3,4,5]
 * 向右旋转 3 步: [5,6,7,1,2,3,4]
 *
 * Created by yyl on 2021/6/17.
 */
public class rotate {
    public void rotate(int[] nums, int k) {
        if(nums.length <= 1){
            return;
        }
        int step = k % nums.length;
        int [] tmp = new int[step];

        for(int i=0; i<step; i++)
            tmp[i] = nums[nums.length-step+i];
        for(int i=nums.length-step-1; i>=0; i--)
            nums[i+step] = nums[i];
        for(int i=0; i<step; i++)
            nums[i] = tmp[i];
    }

    public void rotate1(int[] nums, int k) {
        if(nums.length <= 1){
            return;
        }
        //step each time to move
        int step = k % nums.length;
        reverse(nums,0,nums.length - 1);
        reverse(nums,0,step - 1);
        reverse(nums,step,nums.length - 1);
    }

    //reverse int array from n to m
    public void reverse(int[] nums, int n, int m){
        while(n < m){
            nums[n] ^= nums[m];
            nums[m] ^= nums[n];
            nums[n] ^= nums[m];
            n++;
            m--;
        }
    }

    public static void main(String[] args) {
        int a=2%7;
        System.out.println(a);
    }
}
