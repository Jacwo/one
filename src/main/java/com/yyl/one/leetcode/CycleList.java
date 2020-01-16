package com.yyl.one.leetcode;

import com.yyl.one.offer.ListNode;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * author:yangyuanliang Date:2020-01-16 Time:15:18
 **/
public class CycleList {
    public boolean hasCycle(ListNode head){
        Set<ListNode> set=new HashSet<>();
        while(head!=null){
            if(set.contains(head)){
                return true;
            }
            set.add(head);
            head=head.next;
        }
        return false;
    }


    public boolean hasCycle2(ListNode head){
        if (head == null || head.next == null) {
            return false;
        }
        ListNode slow=head;
        ListNode fast=head.next;
        while (slow!=fast){
            if(slow==null ||fast.next==null){
                return false;
            }
            slow=slow.next;
            fast=fast.next.next;
        }
        return true;
    }
}
