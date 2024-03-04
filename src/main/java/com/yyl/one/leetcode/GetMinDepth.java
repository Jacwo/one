package com.yyl.one.leetcode;

/**
 * @Author yangyuanliang
 * @Date 2024/2/22 10:36
 * @Version 2.0
 **/
public class GetMinDepth {
    //获取二叉树的最小深度
    int getMinDepth(buildTree1.TreeNode root){
        if(root == null){
            return 0;
        }
      return getMin(root);
    }

    private int getMin(buildTree1.TreeNode root) {
        if(root == null){
            return Integer.MAX_VALUE;
        }
        if(root.left == null && root.right == null){
            return 1;
        }
        return Math.min(getMin(root.left),getMin(root.right)+1);
    };




}
