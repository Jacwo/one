package com.yyl.one.leetcode;

/**
 * author:yangyuanliang Date:2019-11-06 Time:14:44
 * http://www.xingxing2019.cn/articleDetail?article_id=43
 * 盛水最多的容器
 **/
public class MaxArea {
    public static int maxArea(int arr[]){
        int l=0,r=arr.length-1,max=0;
        while (l<r){
            max=Math.max(max,Math.min(arr[l],arr[r])*(r-l));
            if(arr[l]<arr[r]){
                l++;
            }else{
                r--;
            }
        }
        return max;
    }
}
