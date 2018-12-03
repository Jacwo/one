package com.yyl.one.array;

/**
 * @author yyl
 * @date 2018/11/24 下午4:20
 * 二分查找原数组有序
 */
public class TwoSearch {
    /**
     * 非递归方式查找
     * @param array
     * @param a
     * @return 查找到的索引值
     */
    public static int binarySearch1(int[] array, int a){
        int lo=0, hi=array.length-1;

        int mid;//中间索引

        while (lo <= hi){
            mid = (lo+hi)/2;

            if(array[mid] == a){
                return mid;
            } else if(array[mid] < a){
                lo = mid+1;
            }else{
                hi = mid-1;
            }
        }
        return -1;
    }

    /**
     * 递归方式查找
     * @param array
     * @param a
     * @return
     */
    public static int binarySearch2(int[] array, int a, int lo, int hi){

        if(lo <= hi){
            int mid = (lo+hi)/2 ;

            if( a == array[mid] ){
                return mid;
            } else if(a > array[mid]){
                return binarySearch2(array, a, mid+1, hi);
            } else {
                return binarySearch2(array, a, lo, mid-1);
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] aa = {1,3,4,5,9,39,44,56};
        System.currentTimeMillis();
        int k = binarySearch2(aa,39,0,8);
        System.out.println(k);
    }
}
