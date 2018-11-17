package com.yyl.one.array;

/**
 * @author yyl
 * @date 2018/11/17 下午11:06
 */
public class ArraySortTest {
    public static void quickSort(int arr[],int left,int right){
       if(left>=right){
           return;
       }

       int start=left;
       int end=right;
       int key=arr[left];
       while(left<right){
           while(left<right && arr[right]>=key){
               right--;
           }
           arr[left]=arr[right];
           while(left<right && arr[left]<=key){
               left++;
           }
           arr[right]=arr[left];
       }
       arr[left]=key;
       quickSort(arr,start,left-1);
       quickSort(arr,left+1,end);

    }

    public static void main(String[] args) {
        int a[]=new int[]{8,3,2,5,7,9,6};
        quickSort(a,0,a.length-1);
        for (int i = 0; i <a.length ; i++) {
            System.out.println(a[i]);
        }
    }


}
