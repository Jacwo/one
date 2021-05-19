package com.yyl.one.leetcode;

/**
 * Created by yyl on 2020/12/15.
 * Suppose a sorted array is rotated at some pivot unknown to you beforehand.
 *
 * (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
 *
 * Find the minimum element.
 */
public class findMin {
    public static int findMin(int[] nums) {
        for(int i=0; i<nums.length-1; i++){
            if(nums[i] > nums[i+1])
                return nums[i+1];
        }
        return nums[0];
    }

    public  int findMin1(int[] nums){
        int left=0, right=nums.length-1, mid;
        while(left < right){
            mid = (left + right)/2;
            if(nums[mid] > nums[right]) {
                if(mid < nums.length-1 && nums[mid] > nums[mid+1])
                    return nums[mid+1];
                left = mid+1;
            }
            else{
                if(mid >0 && nums[mid] < nums[mid-1])
                    return nums[mid];
                right = mid-1;
            }
        }
        return nums[0];
    }

    public int findMin2(int[] nums) {
        int start = 0, end = nums.length - 1, mid;
        while (start  <  end) {
            mid = (start + end) / 2;
            if (nums[mid]  > nums[end])
                start = mid + 1;
            else
                end = mid;
        }
        return nums[start];
    }

    public static void main(String[] args) {
        int[] nums={4,5,6,7,0,1,2};
        int min = findMin(nums);
        System.out.println(min);
    }
}
