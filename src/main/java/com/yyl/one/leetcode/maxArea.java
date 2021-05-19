package com.yyl.one.leetcode;

/**
 给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。
 在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0) 。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 说明：你不能倾斜容器。
 示例 1：
 输入：[1,8,6,2,5,4,8,3,7]
 输出：49
 解释：图中垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]。在此情况下，容器能够容纳水（表示为蓝色部分）的最大值为 49。
 * Created by yyl on 2021/5/13.
 */
public class maxArea {
    public int maxArea(int[] height) {
        int max = 0;
        for(int i=0; i<height.length-1; i++){
            int tmp = height[i];
            for(int j=i+1; j<height.length; j++){
                max = Math.max(max, (j-i)*Math.min(tmp, height[j]));
            }
        }
        return max;
    }
    //双指针法，动动就可以排除一根柱子，进而找到面积最大的
    public int maxArea1(int[] height){
        int max = 0, left=0, right=height.length-1;
        while(left < right){
            if(height[left] < height[right]){
                max = Math.max(max, (right-left)*height[left]);
                left ++;
            }else{
                max = Math.max(max, (right-left)*height[right]);
                right --;
            }
        }
        return max;
    }

    public int maxArea2(int[] height) {
        int lo = 0;
        int hi = height.length - 1;
        int max = 0;
        while(lo < hi) {
            int min = Math.min(height[lo], height[hi]);
            max = Math.max(max, min * (hi - lo));
            while(lo <= hi && height[lo] <= min) lo++;
            while(lo <= hi && height[hi] <= min) hi--;
        }
        return max;
    }
}
