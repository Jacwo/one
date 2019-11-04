package com.yyl.one.array;

public class BubbleSortTest {
    public static void bubbleSort(int []arr){
        //外层循环控制循环总趟数，没次确定一个元素有序
        for(int i=0;i<arr.length;i++){
            //内层循环控制比较次数，已经有序的可以不需要在做比较所以总比较次数arr.length-i-1
            for(int j=0;j<arr.length-i-1;j++){
                if(arr[j]>arr[j+1]){
                    int temp=arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=temp;
                }
            }
        }
        //打印排序后的数组
        for(int k=0;k<arr.length;k++){
            System.out.println(arr[k]);
        }
    }




    public static void main(String[] args) {
        int arr[]=new int[]{7,3,4,1,5};
        bubbleSort(arr);
        for (int i:arr){
            System.out.println(i);
        }
        /*for (int i = 0; i <arr.length ; i++) {
            System.out.println(arr[i]);
        }*/
    }
}
