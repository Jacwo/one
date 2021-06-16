package com.yyl.one.leetcode;

/**
 *
 给你一个长度为 n 的整数数组 nums，其中 n > 1，返回输出数组 output ，
 其中 output[i] 等于 nums 中除 nums[i] 之外其余各元素的乘积。



 示例:

 输入: [1,2,3,4]
 输出: [24,12,8,6]

 * Created by yyl on 2021/6/11.
 */
public class productExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        int[] res = new int[nums.length];
        int mul = 1;
        for(int num : nums)
            mul *= num;
        for(int i=0; i<nums.length; i++){
            res[i] = mul / nums[i];
        }
        return res;
    }

    public  int[] productExpectSelf1(int[] nums){
        int[] res = new int[nums.length];

        for(int i=0; i<nums.length; i++){
            int tmp = 1;
            for(int j=0; j<nums.length; j++)
                if(j != i)
                    tmp *= nums[j];
            res[i] = tmp;
        }

        return res;
    }

    public int[] productExceptSelf2(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        res[0] = 1;
        for (int i = 1; i < n; i++) {
            res[i] = res[i - 1] * nums[i - 1];
        }
        int right = 1;
        for (int i = n - 1; i >= 0; i--) {
            res[i] *= right;
            right *= nums[i];
        }
        return res;
    }


    public int[] productExceptSelf3(int[] nums) {
        int result[]=new int[nums.length];
        int q=1,p=1;
        for(int i=0;i<nums.length;i++){
            result[i]=p;
            p*=nums[i];
        }
        for(int i=nums.length-1;i>0;i--){
            q*=nums[i];
            result[i-1]*=q;
        }
        return  result;
    }

}
