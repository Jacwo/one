package com.yyl.one.array;

/**
 * @author yyl
 * @date 2018/11/18 下午5:47
 */
public class SelectSortTest {
    private static void selectSort(int arr[]){
        for (int i = 0; i < arr.length; i++) {
            int k=i;
            for (int j = k+1; j <arr.length ; j++) {
                if(arr[j]>arr[k]){
                    k=j;
                }
            }
            if(i!=k){
                int temp=arr[i];
                arr[i]=arr[k];
                arr[k]=temp;
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
