package com.yyl.one.leetcode;


import java.util.*;

/**
 * Created by yyl on 2020/12/08
 * 对于一个长度为n+1的数组，其中每一个值的取值范围是[1,n]，可以证明的是必然存在一个重复数字（抽屉原理），
 *  * 找到所有的重复数字。
 *  *
 *  * 举例：输入：[1,3,4,2,1]，输出：1
 */
public class findDuplicates {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> res = new ArrayList<>();
        Arrays.sort(nums);
        for(int i=0; i<nums.length-1; i++){
            if(nums[i] == nums[i+1]) {
                res.add(nums[i]);
                i++;
            }
        }
        return res;
    }

    public List<Integer> findDuplicates1(int[] nums) {
        List<Integer> res = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        for(int num : nums){
            if(map.containsKey(num))
                res.add(num);
            else
                map.put(num, 1);
        }
        return res;
    }

    public static List<Integer> findDuplicates2(int[] nums) {
        List<Integer> res = new ArrayList<>();
        int index;
        for(int i=0; i<nums.length; i++){
            index = Math.abs(nums[i]) - 1;
            if(nums[index] < 0)
                res.add(Math.abs(index+1));
            nums[index] = -nums[index];
        }
        return res;
    }

    public static void main(String[] args){
        int[] nums = {1,2,4,3,7,6,6,5,5};
        List<Integer> duplicates2 = findDuplicates2(nums);

        System.out.println(duplicates2);
    }
}
