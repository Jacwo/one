package com.yyl.one.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 给你一个有序数组 nums ，请你 原地 删除重复出现的元素，使每个元素 最多出现两次 ，返回删除后数组的新长度。
 *
 * 不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
 *
 *  
 *
 * 说明：
 *
 * 为什么返回数值是整数，但输出的答案是数组呢？
 *
 * 请注意，输入数组是以「引用」方式传递的，这意味着在函数里修改输入数组对于调用者是可见的。
 *
 * 你可以想象内部操作如下:
 *
 * // nums 是以“引用”方式传递的。也就是说，不对实参做任何拷贝
 * int len = removeDuplicates(nums);
 *
 * // 在函数里修改输入数组对于调用者是可见的。
 * // 根据你的函数返回的长度, 它会打印出数组中 该长度范围内 的所有元素。
 * for (int i = 0; i < len; i++) {
 *     print(nums[i]);
 * }
 *  
 *
 * 示例 1：
 *
 * 输入：nums = [1,1,1,2,2,3]
 * 输出：5, nums = [1,1,2,2,3]
 * 解释：函数应返回新长度 length = 5, 并且原数组的前五个元素被修改为 1, 1, 2, 2, 3 。 不需要考虑数组中超出新长度后面的元素。
 *
 *
 * Created by yyl on 2021/6/15.
 */
public class removeDuplicates1 {
    public int removeDuplicates(int[] nums) {
        int count = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<nums.length; i++){
            if(!map.containsKey(nums[i])) {
                nums[count] = nums[i];
                map.put(nums[i], 1);
                count++;
            }else if(map.get(nums[i]) == 1) {
                nums[count] = nums[i];
                map.put(nums[i], map.get(nums[i]) + 1);
                count++;
            }
        }
        return count;
    }

    public static int removeDuplicates1(int[] nums){
        if(nums.length<=1)
            return nums.length;
        int count = 1;
        boolean flag = false;
        for(int i=1; i<nums.length; i++){
            if(nums[i] == nums[i-1] && !flag){
                nums[count] = nums[i];
                count++;
                flag = true;
            }else if(nums[i] != nums[i-1]){
                nums[count] = nums[i];
                count++;
                flag = false;
            }
        }
        return count;
    }

    public int removeDuplicates2(int[] nums) {
        int i = 0;
        for (int n : nums)
            if (i < 2 || n > nums[i-2])
                nums[i++] = n;
        return i;
    }

    public static void main(String[] args){
        int[] nums = {1,1,1,2,2,3};
        removeDuplicates1(nums);
    }
}
