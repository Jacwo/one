package com.yyl.one.offer;

import java.util.ArrayList;

/**
 * author:yangyuanliang Date:2019-07-29 Time:13:28
 * 得到最小的k个数
 **/
public class GetLeastNumbers {
    public static ArrayList<Integer> getLestNumbers(Integer input[],Integer k){
        ArrayList<Integer> result=new ArrayList<>();
        if(k>input.length){
            k=input.length;
        }
        int start=0;
        int end=input.length-1;
        int index=get(input,start,end);
        while (index !=k-1){
            if(index<k-1){
                start=index+1;
            }else{
                end=index-1;
            }
            index=get(input,start,end);
        }
        for (int i = 0; i <=index; i++) {
            result.add(input[i]);
        }
        return result;
    }

    private static int get(Integer[] input, int start, int end) {
        int temp=input[start];
        while (start<end){
            while (start<end && input[end]>=temp){
                end--;
            }
            input[start]=input[end];
            while (start<end && input[start]<=temp){
                start++;
            }
            input[end]=input[start];
        }
        input[start]=temp;
        return start;
    }
}
