package com.yyl.one.mianshi;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author yangyuanliang
 * @version 1.9
 * @date 2025/2/20 19:56
 */
public class Mianshi {

	public static void main(String[] args) {
		PriorityQueue<Integer> priorityQueue =new PriorityQueue<>(Comparator.comparingInt(a -> a));
		priorityQueue.add(3);
		priorityQueue.add(5);
		priorityQueue.add(7);
		priorityQueue.add(2);
		priorityQueue.add(9);
		priorityQueue.add(4);
		priorityQueue.add(1);

		System.out.println(priorityQueue);


	}
}
