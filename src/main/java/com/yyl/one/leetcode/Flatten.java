package com.yyl.one.leetcode;

/**
 * @Author yangyuanliang
 * @Date 2024/2/1 15:09
 * @Version 2.0
 **/
public class Flatten {
    public void flatten(buildTree.TreeNode root) {
        while(root!=null){
            if(root.left == null){
                root = root.right;
            }else{

                buildTree.TreeNode pre = root.left;
                while(pre.right!=null){
                    pre = pre.right;
                }

                pre.right=root.right;
                root.right= root.left;
                root.left = null;
                root= root.right;
            }
        }

    }

}
