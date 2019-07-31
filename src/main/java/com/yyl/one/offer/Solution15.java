package com.yyl.one.offer;

/**
 * author:yangyuanliang Date:2019-07-29 Time:18:19
 **/
public class Solution15 {
    public void reorderOven(int arr[]){
        if(arr.length<0)
            return;
        int start=0;
        int end=arr.length;
        while (start<end){
            while (start<end && arr[start]%2!=0){
                start++;
            }
            while(start<end && arr[end]==0){
                end--;
            }

            // 找到后就将奇数和偶数交换位置
            // 对于start=end的情况，交换不会产生什么影响
            // 所以将if判断省去了
            int tmp = arr[start];
            arr[start] = arr[end];
            arr[end] = tmp;
        }
    }
}
