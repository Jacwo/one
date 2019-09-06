package com.yyl.one.leetcode;

import java.util.Stack;

/**
 * author:yangyuanliang Date:2019-09-06 Time:11:09
 **/
public class MyQueue {
        //入
        private Stack<Integer> s1;
        //出
        private Stack<Integer> s2;
        /** Initialize your data structure here. */
        public MyQueue() {
            s1=new Stack();
            s2=new Stack();
        }

        /** Push element x to the back of queue. */
        public void push(int x) {
            while(!s2.isEmpty()){
                s1.push(s2.pop());
            }
            s1.push(x);

        }

        /** Removes the element from in front of queue and returns that element. */
        public int pop() {
            while(!s1.isEmpty()){
                s2.push(s1.pop());
            }
            return s2.pop();
        }

        /** Get the front element. */
        public int peek() {
            while(!s1.isEmpty()){
                s2.push(s1.pop());
            }
            return s2.peek();
        }

        /** Returns whether the queue is empty. */
        public boolean empty() {
            while(!s1.isEmpty()){
                s2.push(s1.pop());
            }
            return s2.isEmpty();
        }


    /**
     * Your MyQueue object will be instantiated and called as such:
     * MyQueue obj = new MyQueue();
     * obj.push(x);
     * int param_2 = obj.pop();
     * int param_3 = obj.peek();
     * boolean param_4 = obj.empty();
     */

    public static void main(String[] args) {
        MyQueue queue=new MyQueue();
        queue.push(1);
        queue.push(2);
        System.out.println(queue.peek());
        int pop = queue.pop();
        System.out.println(pop);
    }
}
