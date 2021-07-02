package com.yyl.one.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个整数数组和一个整数 k，你需要找到该数组中和为 k 的连续的子数组的个数。
 *
 * 示例 1 :
 *
 * 输入:nums = [1,1,1], k = 2
 * 输出: 2 , [1,1] 与 [1,1] 为两种不同的情况。
 *

 * Created by yyl on 2021/06/30
 */
public class subarraySum {
    /**
     * 想一想算法的意思：
     *
     * 计算完包括了当前数前缀和以后，我们去查一查在当前数之前，有多少个前缀和等于 preSum - k 呢？
     * 这是因为满足 preSum - (preSum - k) == k 的区间的个数是我们所关心的。
     *
     * 对于一开始的情况，下标 0 之前没有元素，可以认为前缀和为 0，个数为 1 个，因此 preSumFreq.put(0, 1);，
     * 这一点是必要且合理的。
     * 具体的例子是：nums = [3,...], k = 3，和 nums = [1, 1, 1,...], k = 3。
     *
     * @param nums
     * @param k
     * @return
     */
    public int subarraySum(int[] nums, int k) {
        // key：前缀和，value：key 对应的前缀和的个数
        Map<Integer, Integer> preSumFreq = new HashMap<>();
        // 对于下标为 0 的元素，前缀和为 0，个数为 1
        preSumFreq.put(0, 1);

        int preSum = 0;
        int count = 0;
        for (int num : nums) {
            preSum += num;

            // 先获得前缀和为 preSum - k 的个数，加到计数变量里
            if (preSumFreq.containsKey(preSum - k)) {
                count += preSumFreq.get(preSum - k);
            }

            // 然后维护 preSumFreq 的定义
            preSumFreq.put(preSum, preSumFreq.getOrDefault(preSum, 0) + 1);
        }
        return count;
    }

    public static int subarraySum1(int[] nums, int k) {
        int count=0;
        for(int i=0;i<nums.length;i++){
            int sum=nums[i];
            if(sum==k){
                count++;
            }
            for(int j=i+1;j<nums.length;j++){
                sum+=nums[j];
                if(sum==k) count++;
            }
        }
        return count;
    }


    public static  int subarraySum3(int[] nums, int k) {
        int len = nums.length;
        // 计算前缀和数组
        int[] preSum = new int[len + 1];
        preSum[0] = 0;
        for (int i = 0; i < len; i++) {
            preSum[i + 1] = preSum[i] + nums[i];
        }

        int count = 0;
        for (int left = 0; left < len; left++) {
            for (int right = left; right < len; right++) {
                // 区间和 [left..right]，注意下标偏移
                if (preSum[right + 1] - preSum[left] == k) {
                    count++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int a[]={1,2,3};
        System.out.println(subarraySum3(a,3));
    }
}
