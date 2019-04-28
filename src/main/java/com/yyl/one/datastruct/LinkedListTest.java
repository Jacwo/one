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
        //遍历链表
        while (temp.next!=null){
            temp=temp.next;
        }
        //添加节点到链尾
        temp.next=node;
    }

    public boolean deleteNode(int index){
        if(index<1||index>length()){
            return false;
        }
        //如果删第一个，就把头节点置为null
        if(index==1){
            head=head.next;
            return true;
        }
        //否则拿到两个节点的指针，当前节点和前驱节点
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
    public Node orderList(){
        Node nextNode=null;
        int temp=0;
        Node curNode=head;
        while (curNode!=null){
            nextNode=curNode.next;
            while (nextNode!=null){
                if(curNode.data>nextNode.data){
                    temp=curNode.data;
                    curNode.data=nextNode.data;
                    nextNode.data=curNode.data;
                }
                nextNode=nextNode.next;
            }
            curNode=nextNode.next;
        }
        return head;
    }
    //从尾到头输出链表
    public void reverse(Node head){
        Node preverHead=head;
        Node pNode=head;
        Node pre=null;
        while(pNode!=null){
            Node pNext=pNode.next;
            if(pNext!=null)
                preverHead=pNode;
            pNode.next=pre;
            pre=pNode;
            pNode=pNext;
        }
        this.head=preverHead;
    }
    public Node reverse2(Node head){
        Node next=null;
        Node cur=head;
        Node pre=null;
        while(cur!=null){
            next=head.next;
            cur.next=pre;
            pre=cur;
            cur=next;
        }
        return pre;
        //this.head=preverHead;
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
    //求倒数第k个节点
    public Node getKnode(Node head,int k){
        Node p=head;
        Node q=head;
        for(int j=0;j<k;j++){
            if(p.next!=null){
                p=p.next;
            }
        }
        while (p.next!=null){
            p=p.next;
            q=q.next;
        }
        return q;
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
