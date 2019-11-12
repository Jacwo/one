package com.yyl.one.leetcode;

/**
 * author:yangyuanliang Date:2019-11-12 Time:16:53
 * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
 *
 * ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
 *
 * 搜索一个给定的目标值，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。
 *
 * 你可以假设数组中不存在重复的元素。
 *
 * 你的算法时间复杂度必须是 O(log n) 级别。
 *
 * 示例 1:
 *
 * 输入: nums = [4,5,6,7,0,1,2], target = 0
 * 输出: 4
 **/
public class SearchTest {
    //2分法 logN的时间复杂度
    public static  int search(int[] nums, int target) {
        int left=0;
        int right=nums.length-1;
        while(left<=right){
            //4,5,6,7,0,1,2
            int mid=(left+right)/2;
            if(nums[mid]==target){
                return mid;
            }
            //判断中间的数能连在左边还是右边，即和那边组合能有序
            if(nums[left]<=nums[mid]){
                //和左边连着有序
                if(target<=nums[mid] && target>=nums[left]){
                    //判断target是否在left---mid区间
                    //在的话在堆left----mid-1 进行二分
                    right=mid-1;
                }else{
                    //不在的话在堆mid+1----right 进行二分
                    left=mid+1;
                }
            }else{
                //和右边连着有序
                if(target>=nums[mid] && target<=nums[right]){
                    left=mid+1;
                }else{
                    right=mid-1;
                }
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        int nums[]={4,5,6,7,0,1,2};
        int search = search(nums, 0);
        System.out.println(search);
        int search2 = search(nums, 3);
        System.out.println(search2);

    }
}
