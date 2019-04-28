package com.yyl.one.queue;

import java.util.Queue;

public class ArrayQueueTest {
    private int arr[];
    private int element;
    private int front;
    private int end;
    public ArrayQueueTest(){
        arr=new int[10];
        element=0;
        front=0;
        end=0;
        //Queue
    }
    public void inQueue(int data){
        arr[end++]=data;
        element++;
    }
    public int outQueue(){
        element--;
        return  arr[front++];

    }
}
