package com.yyl.one.leetcode;

/**
 * @Author yangyuanliang
 * @Date 2024/2/26 16:29
 * @Version 2.0
 **/
public class MirrorTreeNode {
    buildTree1.TreeNode mirrorTreeNode(buildTree1.TreeNode root){
        if(root==null){
            return null;
        }
        buildTree1.TreeNode left =mirrorTreeNode(root.left);
        buildTree1.TreeNode right =mirrorTreeNode(root.right);
        root.left =right;
        root.right = left;
        return root;

    }
}
