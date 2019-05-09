package com.yyl.one.offer;

/**
 * 题目描述
 * 输入一个链表，输出该链表中倒数第k个结点。
 */
public class Solution12 {
    public ListNode FindKthToTail(ListNode head,int k) {
        if (head == null || k == 0) {
            return null;
        }

        ListNode node = null;
        ListNode temp = head;
        for (int i = 0; i < k; i++) {
            if (head != null) {
                node = head.next;
                head = node;
            } else {
                return null;
            }

        }

        while (node != null) {
            temp = temp.next;
            node = node.next;
        }
        return temp;
    }
}
