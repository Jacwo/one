package com.yyl.one.leetcode;

/**
 * @Author yangyuanliang
 * @Date 2024/1/24 17:24
 * @Version 2.0
 **/
public class DeepTree {
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode() {}
     *     TreeNode(int val) { this.val = val; }
     *     TreeNode(int val, TreeNode left, TreeNode right) {
     *         this.val = val;
     *         this.left = left;
     *         this.right = right;
     *     }
     * }
     */
    class Solution {
        private int res = 0;
        public int diameterOfBinaryTree(buildTree.TreeNode root) {
            if(root==null){
                return 0;
            }
            maxDepth(root);
            return res;

        }

        public int maxDepth(buildTree.TreeNode node){
            if(node == null){ //访问到空节点了，返回0
                return 0;
            }
            int left = maxDepth(node.left);  // 左儿子为根的子树的深度
            int right = maxDepth(node.right);  // 右儿子为根的子树的深度
            res = Math.max(res,left+right); // 计算d_node即L+R 并更新ans
            return Math.max(left,right)+1;  // 返回该节点为根的子树的深度
        }

    }
}
/**
 * 首先我们知道一条路径的长度为该路径经过的节点数减一，所以求直径（即求路径长度的最大值）等效于求路径经过节点数的最大值减一。
 *
 * 而任意一条路径均可以被看作由某个节点为起点，从其左儿子和右儿子向下遍历的路径拼接得到。
 *
 *
 *
 * 如图我们可以知道路径 [9, 4, 2, 5, 7, 8] 可以被看作以 222 为起点，从其左儿子向下遍历的路径 [2, 4, 9] 和从其右儿子向下遍历的路径 [2, 5, 7, 8] 拼接得到。
 *
 * 假设我们知道对于该节点的左儿子向下遍历经过最多的节点数 LLL （即以左儿子为根的子树的深度） 和其右儿子向下遍历经过最多的节点数 RRR （即以右儿子为根的子树的深度），那么以该节点为起点的路径经过节点数的最大值即为 L+R+1L+R+1L+R+1 。
 *
 * 我们记节点 node\textit{node}node 为起点的路径经过节点数的最大值为 dnoded_{\textit{node}}d
 * node
 * ​
 *   ，那么二叉树的直径就是所有节点 dnoded_{\textit{node}}d
 * node
 * ​
 *   的最大值减一。
 *
 * 最后的算法流程为：我们定义一个递归函数 depth(node) 计算 dnoded_{\textit{node}}d
 * node
 * ​
 *   ，函数返回该节点为根的子树的深度。先递归调用左儿子和右儿子求得它们为根的子树的深度 LLL 和 RRR ，则该节点为根的子树的深度即为
 *
 * max(L,R)+1max(L,R)+1max(L,R)+1
 *
 * 该节点的 dnoded_{\textit{node}}d
 * node
 * ​
 *   值为
 *
 * L+R+1L+R+1L+R+1
 *
 * 递归搜索每个节点并设一个全局变量 ansansans 记录 dnoded_\textit{node}d
 * node
 * ​
 *   的最大值，最后返回 ans-1 即为树的直径。
 *
 */