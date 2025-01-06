package com.yyl.one.collection;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;

/**
 * @author yyl
 * @date 2018/11/18 下午6:53
 */
public class ConcurrentListQueueTest extends  AbstractQueuedSynchronizer{
    //ConcurrentLinkedDeque
    //ArrayList
   // ConcurrentHashMap

	public static void main(String[] args) {
		/*LinkedHashMap map=new LinkedHashMap();
		map.put("2","3");
		map.put("1","2");
		map.put("4","3");*/
		//最近最少使用的在最前面
		LinkedHashMap map=new LinkedHashMap(3,0.75f,true);
		map.put("2","3");
		map.put("1","2");
		map.put("4","3");

		System.out.println(map);
		map.get("1");
		System.out.println(map);


		Set set=new HashSet<>();
		set.add("3");
		set.add("1");
		set.add("2");
		System.out.println(set);

		LinkedHashSet set1 =new LinkedHashSet();
		set1.add("3");
		set1.add("1");
		set1.add("2");
		System.out.println(set1);


	}
}
