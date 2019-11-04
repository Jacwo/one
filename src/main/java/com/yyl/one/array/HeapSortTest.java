package com.yyl.one.array;

/**
 * @author yyl
 * @date 2018/11/18 上午11:00
 * https://juejin.im/post/5dbfdc446fb9a020775fcfb1
 * 堆排序（堆是一种特殊的二叉树，完全二叉树和数组结构符合）
 * 1.堆排序用的是堆这种数据结构是一种选择排序时间复杂度为nlogn，不稳定
 * 2.堆排序是一个具有特性的完全二叉树每个节点的值大于等于左右节点的值称为大顶堆，每个节点的值小于等于左右节点的值称为小顶堆
 * 构建堆，调整堆，每次确定一个最大的保存队尾
 */
public class HeapSortTest {
    //建堆
    public static void buildHeap(int arr[],int curr,int size){
        if(curr<size){
            int left=2*curr+1;
            int right=2*curr+2;
            int max=curr;
            if(left<size){
                if(arr[max]<arr[left]){
                    max=left;
                }
            }
            if(right<size){
                if(arr[max]<arr[right]){
                    max=right;
                }
            }
            if(max!=curr){
                int temp=arr[curr];
                arr[curr]=arr[max];
                arr[max]=temp;
                buildHeap(arr,max,size);
            }

        }
    }
    //
    public static void maxHeap(int arr[],int size){
        for(int j=size-1;j>=0;j--){
            buildHeap(arr,j,size);
        }
    }
    //交换
    public static void heapSort(int arr[]){
        for (int i = 0; i < arr.length; i++) {
            maxHeap(arr,arr.length-i);
            int temp=arr[0];
            arr[0]=arr[arr.length-1-i];
            arr[arr.length-1-i]=temp;
        }

    }
    public static void main(String[] args) {
        int arr[] = new int[]{7, 3, 4, 1, 5, 9, 11};

        heapSort(arr);
        for(int i=0;i<arr.length;i++){
            System.out.println(arr[i]);
        }
    }
}
