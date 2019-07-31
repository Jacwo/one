package com.yyl.one.offer;

/**
 * 题目描述
 * 在一个二维数组中（每个一维数组的长度相同），
 * 每一行都按照从左到右递增的顺序排序，
 * 每一列都按照从上到下递增的顺序排序。请完成一个函数，
 * 输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 */

//思路数组的每一行当作一个有序数组，然后使用二分查找，命中
public class Solution1 {
    public boolean find(int target, int [][] array) {
        for(int i=0;i<array.length;i++){
            int low=0;
            int high=array[i].length-1;
            while(low<=high){
                int mid=(low+high)/2;
                if(array[i][mid]<target){
                    low=mid+1;
                }else if(target<array[i][mid]){
                    high=mid-1;
                }else{
                    return true;
                }
            }
        }
        return false;
    }
}
