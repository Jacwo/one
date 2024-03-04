package com.yyl.one.leetcode;

/**
 * @Author yangyuanliang
 * @Date 2024/2/22 11:13
 * @Version 2.0
 **/
public class NumOfTreeNode {
    //求二叉树的节点个数
    int numOfTreeNode(buildTree1.TreeNode root){
        if(root == null){
            return 0;
        }
        int left = numOfTreeNode(root.left);
        int right = numOfTreeNode(root.right);
        return left + right +1;
    }
}
