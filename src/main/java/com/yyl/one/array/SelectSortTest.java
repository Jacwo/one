package com.yyl.one.array;

/**
 * @author yyl
 * @date 2018/11/18 下午5:47
 */
public class SelectSortTest {
    private static void selectSort(int arr[]){
       for(int i=0;i<arr.length;i++){
           int k=i;
           for(int j=i+1;j<arr.length;j++){
               if(arr[k]>arr[j]){
                   k=j;
               }
           }
           if(k!=i){
               int temp=arr[k];
               arr[k]=arr[i];
               arr[i]=temp;

           }
       }
    }
    public static void main(String[] args) {
        int arr[]=new int[]{7,3,4,1,5};
        selectSort(arr);
        for (int i = 0; i <arr.length ; i++) {
            System.out.println(arr[i]);
        }
    }
}
