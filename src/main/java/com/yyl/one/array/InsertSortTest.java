package com.yyl.one.array;

/**
 * 插入排序
 * http://www.xingxing2019.cn/articleDetail?article_id=30
 *
 */
public class InsertSortTest {

    public static void insertSort(int arr[] ){
        for(int i=1;i<arr.length;i++){
            for(int j=i;j>0;j--){
                if(arr[j]<arr[j-1]){
                    int temp=arr[j];
                    arr[j]=arr[j-1];
                    arr[j-1]=temp;
                }
            }
        }
    }

    public static void insertionSort(int[] arr) {
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            int key = arr[i];
            int j = i - 1;

            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
        }
    }


    public static void main(String[] args) {
                 //           var
        int a[]=new int[]{8,3,2,5,7,9,6};
        insertSort(a);
        for (int i = 0; i <a.length ; i++) {
            System.out.println(a[i]);
        }
    }
}
