package com.yyl.one.offer;

/**
 * author:yangyuanliang Date:2019-07-29 Time:15:12
 * 给出二叉树的前序遍历和中序遍历
 * 重新构造二叉树
 **/
public class Solution13 {
    public static class BinaryTreeNode{
         int val;
         BinaryTreeNode left;
         BinaryTreeNode right;
    }

    public static BinaryTreeNode construct(int []pre,int []in){
        if(pre==null||in==null||pre.length!=in.length||in.length<1){
            return null;
        }
        return construct(pre,0,pre.length-1,in,0,in.length-1);
    }

    private static BinaryTreeNode construct(int[] pre, int ps, int pe, int[] in, int is, int ie) {
        if(ps>pe){
            return null;
        }
        // 取前序遍历根节点找到在中序遍历中的下标
        int value=pre[ps];
        int index=is;
        while (index<=ie && in[index]!=value){
            index++;
        }
        if(index>ie){
            throw new RuntimeException("invalid input");
        }

        BinaryTreeNode node=new BinaryTreeNode();
        node.val=value;

        node.left=construct(pre,ps+1,ps+index-is,in,is,index-1);
        node.right=construct(pre,ps+index-is+1,pe,in,index+1,ie);
        return node;
    }
}
