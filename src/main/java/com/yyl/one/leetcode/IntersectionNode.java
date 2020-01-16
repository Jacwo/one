package com.yyl.one.leetcode;

import com.yyl.one.offer.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * author:yangyuanliang Date:2020-01-16 Time:14:24
 * 相交链表
 * 编写一个程序，找到两个单链表相交的起始节点。
 **/
public class IntersectionNode {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        Set set=new HashSet();
        while(headA!=null){
            set.add(headA);
            headA=headA.next;
        }
        while(headB!=null){
            if(set.contains(headB)){
                return headB;
            }
            headB=headB.next;
        }

        return null;
    }


    public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        if(headA==null ||headB==null){
            return null;
        }
        ListNode p1=headA;
        ListNode p2=headB;
        while(p1!=p2){
            p1 = p1 == null ? headB : p1.next;
            p2 = p2 == null ? headA : p2.next;

        }
        return p1;
    }
}
