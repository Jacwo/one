package com.yyl.one.datastruct;

public class LinkedListTest {
    Node head=null;
    public void add(int data){
        Node node=new Node(data);
        if(head==null){
            head=node;
            return;
        }
        Node temp=head;
        while (temp.next!=null){
            temp=temp.next;
        }
        temp.next=node;
    }

    public boolean deleteNode(int index){
        if(index<1||index>length()){
            return false;
        }
        if(index==1){
            head=head.next;
            return true;
        }
        Node preNode=head;
        Node curNode=preNode.next;
        int i=1;
        while (curNode!=null){
            if(i==index){
                preNode.next=curNode.next;
                return true;
            }
            preNode=preNode.next;
            curNode=curNode.next;
            i++;
        }
        return true;
    }
    public int length(){
        int length=0;
        Node node=head;
        while (node!=null){
            length++;
            node=node.next;
        }
        return length;
    }
    public void print(){
        Node node=head;
        while (node!=null){
            System.out.println(node.data);
            node=node.next;
        }
    }


    public static void main(String[] args) {
        LinkedListTest linkedListTest=new LinkedListTest();
        linkedListTest.add(1);
        linkedListTest.add(2);
        linkedListTest.print();
        linkedListTest.deleteNode(1);
        linkedListTest.print();
    }
}
