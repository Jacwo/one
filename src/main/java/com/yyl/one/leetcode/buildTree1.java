package com.yyl.one.leetcode;

/**
 * Created by yyl on 2020/12/07
 * 根基前序遍历和中序遍历还原二叉树
 *
 */
public class buildTree1 {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public TreeNode buildTree1(int[] preorder, int[] inorder) {
        return buildTree(preorder, 0, inorder, inorder.length - 1, 0);
    }

    private TreeNode buildTree(int[] preorder, int idx, int[] inorder, int end, int start) {
        if (idx >= preorder.length || start > end) {
            return null;
        }
        //前序遍历确定根节点
        TreeNode root = new TreeNode(preorder[idx]);
        int i;
        //在中序遍历中找到根节点,确定左右子树
        for (i = end; i >= start; i--) {
            //找到根节点
            if (preorder[idx] == inorder[i]) {
                break;
            }
        }
        //递归构建左子树
        root.left = buildTree(preorder, idx + 1, inorder, i - 1, start);
        //递归构建右子树
        root.right = buildTree(preorder, idx + i - start + 1, inorder, end, i+1);
        return root;
    }

    public static void main(String[] args) {
        long currentTimeMillis = System.currentTimeMillis();
        System.out.println(currentTimeMillis);
        String s = String.valueOf(currentTimeMillis);
        String substring = s.substring(s.length() - 1);
        System.out.println(substring);
        Long aLong = Long.valueOf(substring);
        long l = 0 % 1;
        System.out.println(l);
    }
}
