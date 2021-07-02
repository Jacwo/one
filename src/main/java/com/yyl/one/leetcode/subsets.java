package com.yyl.one.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。
 *
 * 解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。
 *
 *  
 * 示例 1：
 *
 * 输入：nums = [1,2,3]
 * 输出：[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
 * 示例 2：
 *
 * 输入：nums = [0]
 * 输出：[[],[0]]
 * 链接：https://leetcode-cn.com/problems/subsets
 * Created by yyl on 2021/07/01.
 */
public class subsets {
    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        res.add(new ArrayList<Integer>());

        for(int num :nums){
            List<List<Integer>> tmp = new ArrayList<>();
            for(List<Integer> list : res){
                List<Integer> aa = new ArrayList<>(list);
                aa.add(num);
                tmp.add(aa);
            }
            res.addAll(tmp);
        }

        return res;
    }

    public static List<List<Integer>> subsets1(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(res, new ArrayList<>(), nums, 0);
        return res;
    }

    public static void backtrack(List<List<Integer>> res, List<Integer> tmp, int[] nums, int start){
        res.add(new ArrayList<>(tmp));
        for(int i=start; i<nums.length; i++){
            tmp.add(nums[i]);
            backtrack(res, tmp, nums, i+1);
            tmp.remove(tmp.size()-1);
        }
    }


    public static void main(String[] args){
        int[] nums = {1,2,3};
        subsets1(nums);
    }
}
