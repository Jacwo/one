package com.yyl.one.leetcode;

import java.util.*;

import static java.lang.System.arraycopy;
import static java.lang.System.setOut;

/**
 * author:yangyuanliang Date:2019-11-13 Time:10:28
 **/
public class RemoveDuplicates {
    public static void removeDuplicates(int[] nums) {
        Map<Integer,Integer> map=new HashMap<>();
        int arr[]=new int[nums.length];
        int j=0;
        for(int i=0;i<nums.length;i++){

            if(map.containsKey(nums[i])){
                if(map.get(nums[i])<2){
                    int a= map.get(nums[i])+1;
                    map.put(nums[i],a);
                    arr[i-j]=nums[i];
                }else{
                    j++;
                }
            }else{
                map.put(nums[i],1);
                arr[i-j]=nums[i];
            }
        }
        //Arrays.copyOf()
        //Arrays.sort();
        arraycopy(arr,0,nums,0,nums.length-j);
        //return arr.length;
    }

    public static void main(String[] args) {
        int nums[]={1,2123,324,23423,222,222,222,1,1,2,2,3};
        Map<Integer,Integer> map=new HashMap();
        Collection<Integer> values = map.values();
        for(Integer integer:values){

        }
        Set<Map.Entry<Integer, Integer>> entries = map.entrySet();

        removeDuplicates(nums);
        for (int i=0;i<nums.length;i++){
            System.out.println(nums[i]);
        }
    }
}
