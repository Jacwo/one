package com.yyl.one.array;

import java.util.Arrays;

/**
 * @author yyl
 * @date 2018/11/17 下午10:16
 * 1.system.arraycopy
 * 2.arrays.copyof
 * 3.for
 * 4.clone
 */
public class ArrayCopyTest {
    public static void main(String[] args) {
        int[] array1={1,2,3,4,5};
        int[] array2=new int[array1.length];
        //source arr
        // source arr start
        //dest arr
        //dest arr start
        //copy sum
        System.arraycopy(array1,1,array2,2,3);
        for (int i = 0; i < array2.length; i++) {
             System.out.print(array2[i]);

        }
        System.out.println();
        int[]array3=new int[5];
        for (int i = 0; i <array1.length ; i++) {
            array3[i]=array1[i];
        }
        for (int i = 0; i < array3.length; i++) {
          //  System.out.println(array3[i]);
        }


       // int []array4=new int[5];
        int[] array4 = Arrays.copyOf(array1, 3);
//        int[] copy = new int[newLength];
//        System.arraycopy(original, 0, copy, 0,
//                Math.min(original.length, newLength));
//        return copy;
        for (int i = 0; i < array4.length; i++) {
         //   System.out.println(array4[i]);
        }


        int[] array5=array1.clone();
        for (int i = 0; i < array5.length; i++) {
            System.out.println(array5[i]);
        }
    }
}
