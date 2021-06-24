package com.yyl.one.leetcode;

/**
 * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
 *
 * 如果数组中不存在目标值 target，返回 [-1, -1]。
 *
 * 进阶：
 *
 * 你可以设计并实现时间复杂度为 O(log n) 的算法解决此问题吗？
 *  
 *
 * 示例 1：
 *
 * 输入：nums = [5,7,7,8,8,10], target = 8
 * 输出：[3,4]
 * 示例 2：
 *
 * 输入：nums = [5,7,7,8,8,10], target = 6
 * 输出：[-1,-1]
 *
 * Created by yyl on 2021/6/23.
 */
public class searchRange {
    public int[] searchRange(int[] nums, int target) {
        int[] result = new int[2];
        result[0] = findFirst(nums, target);
        result[1] = findLast(nums, target);
        return result;
    }

    private int findFirst(int[] nums, int target){
        int idx = -1;
        int start = 0;
        int end = nums.length - 1;
        while(start <= end){
            int mid = (start + end) / 2;
            if(nums[mid] >= target){
                end = mid - 1;
            }else{
                start = mid + 1;
            }
            if(nums[mid] == target) idx = mid;
        }
        return idx;
    }

    private int findLast(int[] nums, int target){
        int idx = -1;
        int start = 0;
        int end = nums.length - 1;
        while(start <= end){
            int mid = (start + end) / 2;
            if(nums[mid] <= target){
                start = mid + 1;
            }else{
                end = mid - 1;
            }
            if(nums[mid] == target) idx = mid;
        }
        return idx;
    }


    public int[] searchRange3(int[] nums, int target) {
        int re[]=new int[2];
        boolean flag=false;
        for(int i=0;i<nums.length;i++){
            if(target==nums[i]){
                re[0]=i;
                flag=true;
                break;
            }
        }
        for(int i=nums.length-1;i>0;i--){
            if(target==nums[i]){
                re[1]=i;
                break;
            }
        }
        if(!flag){
            re[0]=-1;
            re[1]=-1;
        }
        return re;
    }

    public int[] searchRange1(int[] nums, int target) {
        int [] res = {-1, -1};
        int left=0, right=nums.length-1, mid, flag=0;
        while(left <= right){
            mid = (left + right) / 2;
            if(nums[mid] > target)
                right = mid-1;
            else if(nums[mid] < target)
                left = mid+1;
            else{
                flag = 1;
                left = mid;
                while(left >=0 && nums[left] == target)
                    left--;
                right = mid;
                while(right <= nums.length-1 && nums[right] == target)
                    right++;
                break;
            }
        }
        if(flag == 1 && nums[left+1] == target){
            res[0] = left+1;
            res[1] = right-1;
        }
        return res;
    }
}
