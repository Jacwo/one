package com.yyl.one.leetcode;

import com.yyl.one.offer.ListNode;

/**
 * author:yangyuanliang Date:2019-11-08 Time:16:55
 * 合并两个有序链表&&合并k个有序链表
 * http://www.xingxing2019.cn/articleDetail?article_id=45
 **/
public class MergeListNode {
    //合并两个有序链表
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head=new ListNode(0);
        ListNode node=head;
        ListNode curr=null;
        while(l1!=null && l2!=null){
            if(l1.val<l2.val){
                curr=new ListNode(l1.val);
                l1=l1.next;
            }else{
                curr=new ListNode(l2.val);
                l2=l2.next;
            }
            node.next=curr;
            node=node.next;
        }
        while(l1!=null){
            node.next=new ListNode(l1.val);
            l1=l1.next;
            node=node.next;
        }
        while(l2!=null){
            node.next=new ListNode(l2.val);
            l2=l2.next;
            node=node.next;
        }
        return head.next;
    }

    //合并k个链表分治法
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length == 0) return null;
        return startMerge(lists,0,lists.length-1);
    }
    public ListNode startMerge(ListNode[] lists,int left,int right){
        if(left==right) return lists[left];
        int mid=(left+right)/2;

        ListNode l1=startMerge(lists,left,mid);
        ListNode l2=startMerge(lists,mid+1,right);
        return mergeTwoLists(l1,l2);
    }
}
