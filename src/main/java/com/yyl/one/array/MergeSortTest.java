package com.yyl.one.array;

/**
 * author:yangyuanliang Date:2019-10-30 Time:18:44
 * 归并排序
 * http://118.31.9.84:3001/articleDetail?article_id=39
 **/
public class MergeSortTest {
    public static void mergeSort(int[] arr) {
        sort(arr, 0, arr.length - 1);
    }

    public static void sort(int[] arr, int left, int right) {
        if(left == right) {
            return;
        }
        //找到中间位置下标
        int mid =(left+right)/2;
        //左路递归
        sort(arr, left, mid);
        //右路递归
        sort(arr, mid + 1, right);
        //合并数组
        merge(arr, left, mid, right);
    }

    public static void merge(int[] arr, int left, int mid, int right) {
        int[] temp = new int[right - left + 1];
        int i = 0;
        int p1 = left;
        int p2 = mid + 1;
        // 比较左右两部分的元素，哪个小，把那个元素填入temp中
        while(p1 <= mid && p2 <= right) {
            temp[i++] = arr[p1] < arr[p2] ? arr[p1++] : arr[p2++];
        }
        // 上面的循环退出后，把剩余的元素依次填入到temp中
        // 以下两个while只有一个会执行
        while(p1 <= mid) {
            temp[i++] = arr[p1++];
        }
        while(p2 <= right) {
            temp[i++] = arr[p2++];
        }
        // 把最终的排序的结果复制给原数组
        for(i = 0; i < temp.length; i++) {
            arr[left+ i] = temp[i];
        }
    }
}
