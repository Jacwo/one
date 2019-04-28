package com.yyl.one.queue;

public class LinkedQueueTest {
    Node front;
    Node tail;
    int size;
    public  LinkedQueueTest(){
        this.front=this.tail=null;
    }
    public void addQueue(int data){
        if(size==0){
            front=new Node(null,1);
            tail=front;
            size++;
        }
        Node s=new Node(null,1);
        tail.next=s;
        tail=s;
        size++;

    }
    public void outQueue(){
        System.out.println(front.data);
        front=front.next;
        size--;
    }
    class Node{
        Node next;
        int data;
        public Node(Node node,int data){
            this.next=node;
            this.data=data;
        }
    }

}
