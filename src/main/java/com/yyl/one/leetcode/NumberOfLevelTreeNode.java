package com.yyl.one.leetcode;

/**
 * @Author yangyuanliang
 * @Date 2024/2/22 14:46
 * @Version 2.0
 **/
public class NumberOfLevelTreeNode {
    //求⼆叉树中第k层节点的个数

    /**
     * 相当于求第k-1层左右节点的个数
     * @param root
     * @param k
     * @return
     */
    int numberOfLevelTreeNode(buildTree1.TreeNode root,int k){
        if(root == null || k<1){
            return 0;
        }
        if(k == 1){
            return 1;
        }

        int numsLeft = numberOfLevelTreeNode(root.left,k-1);
        int numsRight = numberOfLevelTreeNode(root.right,k-1);
        return numsLeft+numsRight;

    }
}
