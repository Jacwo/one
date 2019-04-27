package com.yyl.one.array;

public class InsertSortTest {
    //通过构建有序序列，对未排序的数据，在以排序序列中从后向前扫描
    //找到相应的位置并插入
    public static  void insertSort(int []arr){
        for(int i=1;i<arr.length;i++){
            int val=arr[i]; //2
            int index=i-1;//1
            while (index>=0 && val<arr[index]){
                arr[index+1]=arr[index]; // 第一个赋值给第二个
                index--;
            }
            arr[index+1]=val;

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
