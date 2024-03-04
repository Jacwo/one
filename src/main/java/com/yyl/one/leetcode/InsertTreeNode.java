package com.yyl.one.leetcode;

/**
 * @Author yangyuanliang
 * @Date 2024/2/28 11:34
 * @Version 2.0
 **/
public class InsertTreeNode {
    buildTree1.TreeNode  insertTreeNode(buildTree1.TreeNode root , buildTree1.TreeNode node){
        if(root == null){
            return root;
        }
        buildTree1.TreeNode temp;
        temp = root;
        buildTree1.TreeNode last = null;

        while (temp !=null){
            last = temp;
            if(node.val < temp.val){
                temp = temp.left;
            }else{
                temp = temp.right;
            }
        }

        if(last !=null){
            if(last.val > node.val){
                last.left =node;
            }else{
                last.right =node;
            }
        }
        return root;
    }
}
