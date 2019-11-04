package com.yyl.one.leetcode;

/**
 * author:yangyuanliang Date:2019-11-04 Time:18:31
 **/
public class SortedMid {
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int lengthA=nums1.length;
        int lengthB=nums2.length;
        int temp[]=new int[lengthA+lengthB];

        int p1=0;
        int p2=0;
        int count=0;
        while(count!=(lengthA+lengthB)){
            if (p1 == lengthA) {
                while (p2 != lengthB) {
                    temp[count++] = nums2[p2++];
                }
                break;
            }
            if (p2 == lengthB) {
                while (p1 != lengthA) {
                    temp[count++] = nums1[p1++];
                }
                break;
            }

            if(nums1[p1]<nums2[p2]){
                temp[count++]=nums1[p1++];
            }else{
                temp[count++]=nums2[p2++];
            }

        }

        if (count % 2 == 0) {
            return (temp[count / 2 - 1] + temp[count / 2]) / 2.0;
        } else {
            return temp[count / 2];
        }


    }

    public static void main(String[] args) {
        int a[]={1,3};
        int b[]={2};
        System.out.println(findMedianSortedArrays(a,b));
    }
}
