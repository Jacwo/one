package com.yyl.one.array;

/**
 * @author yyl
 * @date 2018/11/18 上午11:00
 * 堆排序（堆是一种特殊的二叉树，完全二叉树和数组结构符合）
 * 1.堆排序用的是堆这种数据结构是一种选择排序时间复杂度为nlogn，不稳定
 * 2.堆排序是一个具有特性的完全二叉树每个节点的值大于等于左右节点的值称为大顶堆，每个节点的值小于等于左右节点的值称为小顶堆
 * 构建堆，调整堆，每次确定一个最大的保存队尾
 */
public class HeapSortTest {

    public static void main(String[] args) {
        int arr[]=new int[]{7,3,4,1,5};
        //调整堆
        buildHeap(arr,arr.length);

        for (int i = arr.length-1; i >=1; i--) {
            swap(arr,0,i);
            adjustHeap(arr,0,i);

        }
        for (int i = 0; i < arr.length; i++) {

            System.out.println(arr[i]);
        }
    }


    private static void swap(int[] array, int i, int i2) {
        int temp = array[i];
        array[i] = array[i2];
        array[i2] = temp;
    }

    private static void buildHeap(int[] arr, int length) {
        for (int i = length/2-1; i >=0; i--) {
            adjustHeap(arr,i,length);
        }


    }

    private static void adjustHeap(int[] arr, int i,int length) {
        int left=2*i+1;
        int right=left+1;
        int max=0;
        if(left<length && arr[left]>arr[i]){
            max=left;
        }else{
            max=i;
        }

        if(right<length && arr[right]>arr[max]){
            max=right;
        }

        if(max!=i){
            swap(arr,i,max);
            adjustHeap(arr,max,length);
        }

    }
}
