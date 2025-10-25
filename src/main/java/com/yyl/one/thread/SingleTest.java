package com.yyl.one.thread;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @author yangyuanliang
 * @version 1.9
 * @date 2025/2/17 21:05
 */
public class SingleTest {
	private static volatile SingleTest obj;
	private SingleTest(){

	}
	 public static  Object getInstance(){
		if(obj == null){
			synchronized(SingleTest.class){
				if(obj == null){
					obj = new SingleTest();
				}
			}
		}

		return obj;
	 }


	public static void main(String[] args) {
		Map map =new HashMap<>();
		PriorityQueue<Integer> queMin =new PriorityQueue<>((a,b)->(b-a));
		queMin.offer(3);
		queMin.offer(6);
		System.out.println(queMin.peek());
		ArrayList<String> array = new ArrayList<String>();
		array.add(1,"hello world");
		System.out.println(array);
		Character.isDigit('a');
	}

}
