package com.yyl.one.treenode;

import java.util.LinkedList;

public class TreeNodeTest {
    //wangquanfeng
    class TreeNode{
        int data;
        TreeNode left;
        TreeNode right;
        public TreeNode(int data){
            this.data=data;
        }
    }

    //前序
    public void preOrder(TreeNode treeNode){
        System.out.println(treeNode.data);
        TreeNode left=treeNode.left;
        if(left!=null){
            preOrder(left);
        }
        TreeNode right=treeNode.right;
        if(right!=null){
            preOrder(right);
        }
    }

    public void levleOrder(TreeNode treeNode){
        if(treeNode==null){
            return;
        }
        LinkedList<TreeNode>linkedList=new LinkedList<>();
        linkedList.add(treeNode);
        TreeNode curNode;
        while(!linkedList.isEmpty()){
            curNode=linkedList.poll();
            System.out.println(curNode.data);
            if(curNode.left!=null){
                linkedList.add(curNode.left);
            }
            if(curNode.right!=null){
                linkedList.add(curNode.right);
            }
        }
    }
}
