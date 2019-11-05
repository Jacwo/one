package com.yyl.one.leetcode;

import com.yyl.one.offer.ListNode;

import java.util.List;

/**
 * author:yangyuanliang Date:2019-11-05 Time:16:01
 * 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
 * http://www.xingxing2019.cn/articleDetail?article_id=42
 **/
public class RemoveNthFromEnd {
    public static ListNode  removeNthFromEnd(ListNode head,int n){
        ListNode dummy=new ListNode(0);
        dummy.next=head;
        ListNode p1=dummy;
        ListNode curr=dummy;
        for(int i=0;i<n;i++){
            p1=p1.next;
        }
        while (p1.next!=null){
            p1=p1.next;
            curr=curr.next;
        }
        curr.next=curr.next.next;
        return dummy.next;

    }

    public static void main(String[] args) {
        ListNode listNode=new ListNode(1);
        listNode.next=new ListNode(2);
        listNode.next.next=new ListNode(3);
        listNode.next.next.next=new ListNode(4);
        ListNode listNode1 = removeNthFromEnd(listNode, 3);
        while (listNode1!=null){

            System.out.println(listNode1.val);
            listNode1=listNode1.next;
        }

    }
}
