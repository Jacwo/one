package com.yyl.one.array;

/**
 * author:yangyuanliang Date:2019-11-06 Time:17:48
 **/
public class ShellSortTest {
    public static void shellSort(int arr[]){
        int gap=arr.length;
        while (true){
            gap=gap/2;
            for(int i=0;i<=gap;i++){
                for(int j=i+gap;j>=0 && j-gap>=0;j-=gap){
                    if(arr[j]<arr[j-gap]){
                        int temp=arr[j];
                        arr[j]=arr[j-gap];
                        arr[j-gap]=temp;
                    }
                }
            }
            if(gap==1){
                break;
            }
        }
    }

    public static void main(String[] args) {
        //           var
        int a[]=new int[]{8,3,2,5,7,9,6};
        shellSort(a);
        for (int i = 0; i <a.length ; i++) {
            System.out.println(a[i]);
        }
    }
}
