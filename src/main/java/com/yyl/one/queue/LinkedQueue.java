package com.yyl.one.queue;

/**
 * @author yangyuanliang
 * @version 1.9
 * @date 2025/3/3 19:55
 */
public class LinkedQueue<T> {
	private int size;
	private Node front;
	private Node tail;

	class Node<T> {
		private Node next;
		private T data;
		public Node(Node next,T data){
			this.next = next;
			this.data = data;
		}
	}



	public void inQueue(T data){
		if(size == 0){
			front = new Node(null,data);
			tail = front;
		}else{
			Node node = new Node(null,data);
			tail.next =node;
			tail = node;
		}

		size++;
	}

	public T outQueue(){
		T data = (T) front.data;
		size--;
		front = front.next;
		return data;
	}


	public static void main(String[] args) {
		LinkedQueue<Integer> linkedQueue =new LinkedQueue<>();
		linkedQueue.inQueue(1);
		linkedQueue.inQueue(3);
		linkedQueue.inQueue(5);
		linkedQueue.inQueue(7);
		System.out.println(linkedQueue.outQueue());
		System.out.println(linkedQueue.outQueue());
		System.out.println(linkedQueue.outQueue());
		System.out.println(linkedQueue.outQueue());


	}
}
