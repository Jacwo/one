package com.yyl.one.offer;

import java.util.ArrayList;
import java.util.Stack;

/**
 * 题目描述
 * 输入一个链表，按链表值从尾到头的顺序返回一个ArrayList。
 */
public class Solution3 {
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> list = new ArrayList();
        ListNode head = listNode;
        if (head == null) {
            return list;
        }
        //反转链表
        //1.定义当前节点，下一节点，前一节点
        ListNode curr = head;
        ListNode next = null;

        ListNode pre = null;
        while (curr != null) {
            next = curr.next; //记录下一节点
            curr.next = pre;  //当前节点指向前一节点
            pre = curr;      //前一节点后移
            curr = next;   //当前节点后移

        }

        while (pre != null) {
            list.add(pre.val);
            pre = pre.next;
        }
        return list;
    }
    //使用栈
    public ArrayList<Integer> printListFromTailToHead2(ListNode listNode) {
        ArrayList<Integer> list = new ArrayList();
        ListNode head = listNode;
        if (head == null) {
            return list;
        }

        Stack<Integer> stack=new Stack();
        while (head != null) {
            stack.push(head.val);
            head = head.next;
        }
        while(!stack.isEmpty()){
            list.add(stack.pop());
        }
        return list;
    }
}
