package com.yyl.one.leetcode;

/**
 *
 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。

 示例:

 输入: [0,1,0,3,12]
 输出: [1,3,12,0,0]
 说明:

 必须在原数组上操作，不能拷贝额外的数组。
 尽量减少操作次数。
 * Created by yyl on 2021/6/17.
 */
public class moveZeroes {
    public static void moveZeroes(int[] nums) {
        int count=0, left=0;
        for(int i=0; i<nums.length; i++) {
            if (nums[i] == 0)
                count++;
            else
                nums[i - count] = nums[i];
        }
        for(int i=0; i<count; i++)
            nums[nums.length-i-1] = 0;
    }

    public void moveZeroes1(int[] nums) {
        if (nums == null || nums.length == 0) return;

        int insertPos = 0;
        for (int num: nums) {
            if (num != 0) nums[insertPos++] = num;
        }

        while (insertPos < nums.length) {
            nums[insertPos++] = 0;
        }
    }

    public void moveZeroes2(int[] nums) {

        int j = 0;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] != 0) {
                int temp = nums[j];
                nums[j] = nums[i];
                nums[i] = temp;
                j++;
            }
        }
    }
    public void moveZeroes3(int[] nums) {
        int k=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==0){
                k++;
            }else{
                int temp=nums[i];
                nums[i]=0;
                nums[i-k]=temp;
            }
        }
    }
    public static void main(String [] args){
        int [] nums = {0,1,0,3,12};
        moveZeroes(nums);
    }
}
