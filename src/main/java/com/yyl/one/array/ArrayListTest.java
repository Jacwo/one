package com.yyl.one.array;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @Author yangyuanliang
 * @Date 2022/11/24 14:59
 * @Version 2.0
 **/
public class ArrayListTest {

    public static void main(String[] args) {
        List<String> list =new ArrayList<>();
        list.add("222");
        Object[] elementData = new Object[3];
        elementData[0] = "0";
        elementData[1] = "1";

        elementData[2] = "2";
        System.out.println(elementData.length);

        Object[] objects = Arrays.copyOf(elementData, 6);
        System.out.println(objects.length);
        // 每次新增会检测扩容，扩容是基于数组的复制
        /**
         *  Arrays.copyOf(elementData, newCapacity);
         *  System.arraycopy(original, 0, copy, 0, Math.min(original.length, newLength));
         */

        List<String> list2=new CopyOnWriteArrayList<>();
        // 写操作会先获取到锁，复制数组，生成一个新的，然后再新数组上操作写入，
        list2.add("222");
        // 读操作还在原数组获取，读写分离
        list2.get(0);
        /**
         * 基于双向
         */
        List<String> list3=new LinkedList<>();
        list3.add("3");
        list3.remove("3");
        // 方法是同步的
        List<String> list4 =new Vector<>();
        list4.add("4");
        list4.remove("4");
        // 线程安全继承了Vector，先进后出
        Stack<String> list5 =new Stack<>();
        //入栈放在最后
        list5.push("222");
        //从最后取
        list5.pop();


    }
}
