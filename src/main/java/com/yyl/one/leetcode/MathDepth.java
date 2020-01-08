package com.yyl.one.leetcode;

/**
 * author:yangyuanliang Date:2020-01-07 Time:17:07
 * 二叉树的最大深度
 **/
public class MathDepth {
       class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
    public int maxDepth(TreeNode root){
        if(root==null){
            return 0;
        }
        int left=maxDepth(root.left);
        int right=maxDepth(root.right);
        return Math.max(left,right)+1;
    }
}
