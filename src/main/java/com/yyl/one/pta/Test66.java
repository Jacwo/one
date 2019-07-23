package com.yyl.one.pta;

import java.util.Scanner;

/**
 * author:yangyuanliang Date:2019-07-22 Time:17:21
 *
 * 本题要求实现一个函数，求单链表L结点的阶乘和。这里默认所有结点的值非负，且题目保证结果在int范围内。
 *
 **/
public class Test66 {

    static class Node{
        private int data;
        private Node next;
        public Node(int data){
            this.data=data;
            this.next=null;
        }
    }
    public static int jiecheng(int n){
        int sum =1;
        for(int i=1;i<=n;i++){
            sum=sum*i;
        }
        return  sum;
    }
    public static void main(String[] args) {
        System.out.println("请输入链表长度");
        Scanner s=new Scanner(System.in);
        int n=s.nextInt();
        int sum=0;
        Node head=new Node(0);
        for (int i=0;i<n;i++){
            System.out.println("请输入链表结点");
            Node node=new Node(s.nextInt());
            //头插法，切记切记
            node.next=head;
            head=node;
        }
        while (head.next!=null){
            sum+=jiecheng(head.data);
            head=head.next;
        }
        System.out.println(sum);
    }
}
