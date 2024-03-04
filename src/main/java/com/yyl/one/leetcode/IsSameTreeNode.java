package com.yyl.one.leetcode;

/**
 * @Author yangyuanliang
 * @Date 2024/2/26 15:58
 * @Version 2.0
 **/
public class IsSameTreeNode {
    boolean isSameTreeNode(buildTree1.TreeNode node, buildTree1.TreeNode node2){
        if(node== null && node2 == null){
            return true;
        }else if(node == null || node2 ==null){
            return false;
        }
        if(node.val != node2.val){
            return false;
        }

        boolean left = isSameTreeNode(node.left,node2.left);
        boolean right = isSameTreeNode(node.right,node2.right);
        return left && right;
    }
}
