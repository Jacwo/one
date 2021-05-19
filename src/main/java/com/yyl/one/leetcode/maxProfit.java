package com.yyl.one.leetcode;

/**
 * 假设把某股票的价格按照时间先后顺序存储在数组中，请问买卖该股票一次可能获得的最大利润是多少？
 *
 *  
 *
 * 示例 1:
 *
 * 输入: [7,1,5,3,6,4]
 * 输出: 5
 * 解释: 在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
 *      注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格。
 * 示例 2:
 *
 * 输入: [7,6,4,3,1]
 * 输出: 0
 * 解释: 在这种情况下, 没有交易完成, 所以最大利润为 0。

 * Created by yyl on 2021/4/9.
 */
public class maxProfit {
    public int maxProfit2(int[] prices) {
        int left = 0, max = 0;
        for(int i=0; i<prices.length; i++){
            if(prices[i] > prices[left])
                max = Math.max(max, prices[i] - prices[left]);
            else
                left = i;
        }
        return max;
    }

    public static int maxProfit(int[] nums) {
        if(nums.length==0) return 0;
        int max =nums[nums.length-1];
        int result=0;
        for(int i=nums.length-1;i>=1;i--){
            if(i!=1 && max<nums[i-1]  ){
                max= nums[i-1];
            }
            result =Math.max(result,max-nums[i-1]);

        }
        return result;
    }

    public static void main(String[] args) {
        int a[] ={7,1,5,3,6,4};
        System.out.println(maxProfit(a));
    }
}
