package com.yyl.one.leetcode;

/**
 * @Author yangyuanliang
 * @Date 2024/1/31 14:59
 * @Version 2.0
 * 在二叉搜索树中，任意子节点都满足“左子节点 <<< 根节点 <<< 右子节点”的规则。因此二叉搜索树具有一个重要性质：二叉搜索树的中序遍历为递增序列。
 *
 * 也就是说，本题可被转化为求中序遍历的第 kkk 个节点。
 *
 *
 *
 * 为求第 kkk 个节点，需要实现以下三项工作：
 *
 * 递归遍历时计数，统计当前节点的序号。
 * 递归到第 kkk 个节点时，应记录结果 resresres 。
 * 记录结果后，后续的遍历即失去意义，应提前返回。
 *
 **/
public class KthSmallest {
    int res,k;
    public int kthSmallest(buildTree.TreeNode root, int k) {
        this.k = k;
        dfs(root);
        return res;
    }

    void dfs(buildTree.TreeNode root){
        if(root == null){
            return;
        }
        dfs(root.left);
        if(k==0){
            return;
        }
        k--;
        if(k == 0){
            res = root.val;
        }
        dfs(root.right);
    }
}
