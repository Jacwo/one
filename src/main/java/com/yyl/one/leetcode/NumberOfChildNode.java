package com.yyl.one.leetcode;

/**
 * @Author yangyuanliang
 * @Date 2024/2/22 14:42
 * @Version 2.0
 **/
public class NumberOfChildNode {
    //二叉树中叶子节点个数
    int numOfChildNode(buildTree1.TreeNode root){
        if(root == null){
            return 0;
        }
        if(root.left == null && root.right == null){
            return 1;
        }
        return numOfChildNode(root.left)+numOfChildNode(root.right);
    }
}
