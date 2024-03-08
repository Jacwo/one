package com.yyl.one.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by yyl on 2020/12/08.
 * 给定一个范围在  1 ≤ a[i] ≤ n ( n = 数组大小 ) 的 整型数组，数组中的元素一些出现了两次，另一些只出现一次。
 *
 * 找到所有在 [1, n] 范围之间没有出现在数组中的数字。
 *
 * 您能在不使用额外空间且时间复杂度为O(n)的情况下完成这个任务吗? 你可以假定返回的数组不算在额外空间内。
 *
 * 示例:
 *
 * 输入:
 * [4,3,2,7,8,2,3,1]
 *
 * 输出:
 * [5,6]
 */
public class findDisappearedNumbers {
    public static List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> res = new ArrayList<>();
        //数组排序.dis用户消除错位。
        Arrays.sort(nums);
        int dis = 0;
        for(int i=0; i<nums.length; i++){
            //数组元素大于当前位置，说明当前位置少了，直接加
            if(nums[i] > i+1 && dis == 0)
                res.add(i+1);
            //数组元素加上dis小于当前位置说明前面有重复的值，记录
            else if(nums[i]+dis < i+1) {
                dis++;
                //数组元素加上dis大于当前位置，说明数组元素前面的少了
            }else if(nums[i]+dis > i+1)
                //依次拿到缺少的数组
                while(dis > 0)
                    res.add(nums[i] - dis--);
        }
        //最后一个也要判断
        while(dis>0)
            res.add(nums.length - dis-- +1);
        return res;
    }

    public static List<Integer> findDisappearedNumbers1(int[] nums) {
        List<Integer> ret = new ArrayList<Integer>();

        for(int i = 0; i < nums.length; i++) {
            int val = Math.abs(nums[i]) - 1;
            if(nums[val] > 0) {
                nums[val] = -nums[val];
            }
        }

        for(int i = 0; i < nums.length; i++) {
            if(nums[i] > 0) {
                ret.add(i+1);
            }
        }
        return ret;
    }
    //巧妙使用boolean数组，牛逼
    public List<Integer> findDisappearedNumbers2(int[] nums) {
        boolean[] bloom = new boolean[nums.length];
        for (int n : nums) {
            bloom[n-1] = true;
        }
        List<Integer> result = new ArrayList<Integer>();
        for (int i = 0; i < bloom.length; i++) {
            if (!bloom[i]) {
                result.add(i+1);
            }
        }
        return result;
    }

    public static void main(String [] args){
        int [] nums = {4,3,2,7,8,2,3,1};
        findDisappearedNumbers(nums);
    }
}
