package com.yyl.one.leetcode;

import java.util.HashMap;
import java.util.Stack;

/**
 * Created by yyl on 2020/12/07
 * 根据二叉树中序和后序，还原二叉树
 *
 * 基础
 * 二叉树中序遍历
 * 左根右
 * 二叉树后序遍历
 * 左右根
 *
 * 前序遍历
 * 根左右
 */
public class buildTree {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return build(inorder, inorder.length-1, 0, postorder, postorder.length-1);
    }

    public TreeNode build(int[] inorder, int inStart, int inEnd, int[] postorder, int postStart){
        if(inEnd > inStart)
            return null;
        //后序遍历左右一个是根结点，找到根节点
        TreeNode root = new TreeNode(postorder[postStart]);
        if(inEnd == inStart)
            return root;
        int index = 0;
        //循环中序遍历数组，找到根节点的位置，左侧是左子树节点，右侧是又子树的节点
        for(int i=inStart; i>=inEnd; i--){
            if(inorder[i] == root.val){
                index=i;
                break;
            }
        }
        //递归取得所有右子树
        root.right = build(inorder, inStart, index+1, postorder, postStart-1);
        //递归取得所有左子树  postStart-(inStart-index)-1 是找到根节点的左子树
        //即后序遍历最后一个减去，中序根结点的位置到最右侧节点的个数
        root.left = build(inorder, index-1, inEnd, postorder, postStart-(inStart-index)-1);
        return root;
    }

    public TreeNode buildTree1(int[] inorder, int[] postorder) {
        if (inorder == null || postorder == null || inorder.length != postorder.length)
            return null;
        HashMap<Integer, Integer> hm = new HashMap<Integer,Integer>();
        for (int i=0;i<inorder.length;++i)
            hm.put(inorder[i], i);
        return buildTreePostIn(inorder, 0, inorder.length-1, postorder, 0,
                postorder.length-1,hm);
    }

    private TreeNode buildTreePostIn(int[] inorder, int is, int ie, int[] postorder, int ps, int pe,
                                     HashMap<Integer,Integer> hm){
        if (ps>pe || is>ie) return null;
        TreeNode root = new TreeNode(postorder[pe]);
        int ri = hm.get(postorder[pe]);
        root.left = buildTreePostIn(inorder, is, ri-1, postorder, ps, ps+ri-is-1, hm);
        root.right = buildTreePostIn(inorder,ri+1, ie, postorder, ps+ri-is, pe-1, hm);
        return root;
    }

    public TreeNode buildTree2(int[] inorder, int[] postorder) {
        if (inorder.length == 0 || postorder.length == 0) return null;
        int ip = inorder.length - 1;
        int pp = postorder.length - 1;

        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode prev = null;
        TreeNode root = new TreeNode(postorder[pp]);
        stack.push(root);
        pp--;

        while (pp >= 0) {
            while (!stack.isEmpty() && stack.peek().val == inorder[ip]) {
                prev = stack.pop();
                ip--;
            }
            TreeNode newNode = new TreeNode(postorder[pp]);
            if (prev != null) {
                prev.left = newNode;
            } else if (!stack.isEmpty()) {
                TreeNode currTop = stack.peek();
                currTop.right = newNode;
            }
            stack.push(newNode);
            prev = null;
            pp--;
        }

        return root;
    }
}
