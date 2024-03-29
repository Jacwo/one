package com.yyl.one.leetcode;

/**
 * Created by yyl on 2020/12/08.
 * 对于一个长度为n+1的数组，其中每一个值的取值范围是[1,n]，可以证明的是必然存在一个重复数字（抽屉原理），
 * 假设仅存在一个重复数字，找到他。
 *
 * 举例：输入：[1,3,4,2,1]，输出：1
 *
 *
 */
public class findDuplicate {
    public int findDuplicate(int[] nums) {
        for(int i=0; i<nums.length; i++){
            for(int j=i+1; j<nums.length; j++){
                if(nums[i] == nums[j])
                    return nums[i];
            }
        }
        return 0;
    }

    public static int findDuplicate1(int[] nums) {
        int low=1, high=nums.length-1, mid;
        while(low < high){
            mid = low + (high-low)/2;
            int count = 0;
            for(int i=0; i<nums.length; i++){
                if(nums[i] <= mid)
                    count++;
            }
            if(count > mid)
                high = mid;
            else
                low = mid + 1;
        }
        return low;
    }

    public static int findDuplicate2(int[] nums) {
        int n = nums.length;
        int slow = n;
        int fast = n;
        do{
            slow = nums[slow-1];
            fast = nums[nums[fast-1]-1];
        }while(slow != fast);
        slow = n;
        while(slow != fast){
            slow = nums[slow-1];
            fast = nums[fast-1];
        }
        return slow;
    }

    public static void main(String[] args){
        int[] nums = {1,2,4,3,7,6,8,5,5};
        int num = findDuplicate2(nums);
        System.out.println(num);
    }
}
