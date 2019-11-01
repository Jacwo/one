package com.yyl.one.array;

/**
 * author:yangyuanliang Date:2019-10-30 Time:18:44
 * 归并排序
 * http://118.31.9.84:3001/articleDetail?article_id=39
 **/
public class MergeSortTest {
    public static void sort(int arr[],int left,int right){
        if(left == right) {
            return;
        }
        int mid=(left+right)/2;
        sort(arr,left,mid);
        sort(arr,mid+1,right);
        merge(arr,left,mid,right);
    }

    private static void merge(int[] arr, int left,int mid, int right) {
        int temp[]=new int[right-left+1];
        int p1=left;
        int p2=mid+1;
        int i=0;
        while (p1<=mid && p2<=right){
            temp[i++]=arr[p1]<arr[p2]?arr[p1++]:arr[p2++];
        }
        while (p1<=mid){
            temp[i++]=arr[p1++];
        }
        while (p2<=right){
            temp[i++]=arr[p2++];
        }
        for(int j=0;j<temp.length;j++){
            arr[left+j]=temp[j];
        }



    }

    public static void main(String[] args) {
        int a[]={2,3,43,5};
        sort(a,0,a.length-1);
        for (int i:a){
            System.out.println(i);
        }
    }
}
