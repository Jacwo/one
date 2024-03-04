package com.yyl.one.leetcode;

import java.util.*;

/**
 * @Author yangyuanliang
 * @Date 2024/2/27 14:15
 * @Version 2.0
 **/
public class PreOrder {

    List<Integer> preOrder(buildTree1.TreeNode root) {
        List<Integer> result = new ArrayList<>();

        Stack<buildTree1.TreeNode> stack = new Stack<>();
        if (root == null) {
            return result;
        }
        stack.push(root);
        while (!stack.empty()) {
            buildTree1.TreeNode pop = stack.pop();
            result.add(pop.val);
            if (pop.right != null) {
                stack.push(pop.right);
            }
            if (pop.left != null) {
                stack.push(pop.left);
            }
        }
        return result;
    }

    ArrayList<Integer> preOrderReverse(buildTree1.TreeNode root) {
        ArrayList<Integer> result = new ArrayList<>();
        preOrder2(root, result);
        return result;

    }

    void preOrder2(buildTree1.TreeNode root, ArrayList<Integer> result) {
        if (root == null) {
            return;
        }
        result.add(root.val);
        preOrder2(root.left, result);
        preOrder2(root.right, result);
    }


    class BinaryTreeLevelOrderTraversal {
        public List<List<Integer>> levelOrder(buildTree1.TreeNode root) {
            List<List<Integer>> result = new ArrayList<>(); // 存放结果的列表

            if (root == null) {
                return result;
            }

            Queue<buildTree1.TreeNode> queue = new LinkedList<>(); // 创建一个队列作为辅助数据结构
            queue.offer(root); // 将根节点加入队列中

            while (!queue.isEmpty()) {
                List<Integer> levelResult = new ArrayList<>(); // 当前层次的结果列表

                int size = queue.size(); // 获取当前层次的元素个数

                for (int i = 0; i < size; i++) {
                    buildTree1.TreeNode node = queue.poll(); // 从队列头部移除一个节点

                    levelResult.add(node.val); // 添加该节点到当前层次的结果列表中

                    if (node.left != null) {
                        queue.offer(node.left); // 如果有左子节点则加入队列尾部
                    }

                    if (node.right != null) {
                        queue.offer(node.right); // 如果有右子节点则加入队列尾部
                    }
                }

                result.add(levelResult); // 将当前层次的结果列表加入最终结果列表中
            }

            return result;
        }
    }
}