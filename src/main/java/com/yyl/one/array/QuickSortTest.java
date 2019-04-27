package com.yyl.one.array;

/**
 * @author yyl
 * @date 2018/11/17 下午11:06
 */
public class QuickSortTest {
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
    public static void quickSort2(int arr[],int low,int high){
        int key=arr[low];
        int start=low;
        int end=high;
        while(end>start){
            while (end>start&& arr[end]>=key){
                end--;
            }
            if(arr[end]<=key){
                int temp=arr[end];
                arr[end]=arr[start];
                arr[start]=temp;
            }
            while (start<end&& arr[start]<=key){
                start++;
            }
            if(arr[start]>=key){
                int temp=arr[start];
                arr[start]=arr[end];
                arr[end]=temp;
            }
        }
        if(start>low){
            quickSort2(arr,low,start-1);

        }
        if(end<high){
            quickSort2(arr,end+1,high);
        }
    }
    public static void main(String[] args) {
        int a[]=new int[]{8,3,2,5,7,9,6};
        quickSort2(a,0,a.length-1);
        for (int i = 0; i <a.length ; i++) {
            System.out.println(a[i]);
        }
    }


}
