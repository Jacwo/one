package com.yyl.one.leetcode;

/**
 *
 给定一个包含红色、白色和蓝色，一共 n 个元素的数组，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。

 此题中，我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。



 示例 1：

 输入：nums = [2,0,2,1,1,0]
 输出：[0,0,1,1,2,2]
 示例 2：

 输入：nums = [2,0,1]
 输出：[0,1,2]
 * Created by yyl on 2021/6/28.
 */
public class sortColors {
    public void sortColors(int[] nums) {
        int a=0, b=0;
        for(int num : nums){
            if(num == 0)
                a++;
            else if(num == 1)
                b++;
        }
        for(int i=0; i<nums.length; i++){
            if(i<a)
                nums[i] = 0;
            else if(i < a+b)
                nums[i] = 1;
            else
                nums[i] = 2;
        }
    }
    class Solution {
        public void sortColors(int[] nums) {
            int a=0;
            int b=0;
            for(int i=0;i<nums.length;i++){
                if(nums[i]==0){
                    a++;
                }
                if(nums[i]==1){
                    b++;
                }
            }
            for(int i=0;i<nums.length;i++){
                if(i<a){
                    nums[i]=0;
                }else if(i<b+a){
                    nums[i]=1;
                }else{
                    nums[i]=2;
                }
            }
        }
    }
    public void sortColors1(int[] nums) {
        int n = nums.length, n0 = -1, n1 = -1, n2 = -1;
        for (int i = 0; i < n; ++i) {
            if (nums[i] == 0)
            {
                nums[++n2] = 2; nums[++n1] = 1; nums[++n0] = 0;
            }
            else if (nums[i] == 1)
            {
                nums[++n2] = 2; nums[++n1] = 1;
            }
            else if (nums[i] == 2)
            {
                nums[++n2] = 2;
            }
        }
    }

    public void sortColors2(int[] nums) {
        int n=nums.length, j = 0, k = n - 1;
        for (int i = 0; i <= k; ++i){
            if (nums[i] == 0 && i != j)
                swap(nums, i--, j++);
            else if (nums[i] == 2 && i != k)
                swap(nums, i--, k--);
        }
    }

    public void swap(int[] nums, int a, int b){
        int tmp = nums[a];
        nums[a] = nums[b];
        nums[b] = tmp;
    }

}
