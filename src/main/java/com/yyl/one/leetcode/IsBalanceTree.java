package com.yyl.one.leetcode;

/**
 * @Author yangyuanliang
 * @Date 2024/2/26 10:56
 * @Version 2.0
 **/
public class IsBalanceTree {
    boolean isBalanced(buildTree1.TreeNode root){

        return maxDeath(root) != -1;
    }

    private int maxDeath(buildTree1.TreeNode root) {
        if(root == null){
            return 0;
        }
        int left = maxDeath(root.left);
        int right = maxDeath(root.right);
        if(left ==-1 || right == -1 || Math.abs(left-right)>1){
            return -1;
        }
        return Math.max(left,right)+1;
    }
}
