package com.yyl.one.leetcode;

/**
 * 在MATLAB中，有一个非常有用的函数 reshape，它可以将一个矩阵重塑为另一个大小不同的新矩阵，但保留其原始数据。
 * 给出一个由二维数组表示的矩阵，以及两个正整数r和c，分别表示想要的重构的矩阵的行数和列数。
 * 重构后的矩阵需要将原始矩阵的所有元素以相同的行遍历顺序填充。
 * 如果具有给定参数的reshape操作是可行且合理的，则输出新的重塑矩阵；否则，输出原始矩阵。
 *
 * 示例 1:
 * 输入:
 * nums =
 * [[1,2],
 *  [3,4]]
 * r = 1, c = 4
 * 输出:
 * [[1,2,3,4]]
 * 解释:
 * 行遍历nums的结果是 [1,2,3,4]。新的矩阵是 1 * 4 矩阵, 用之前的元素值一行一行填充新矩阵。
 * Created by yyl on 2017/5/3.
 */
public class matrixReshape {
    public int[][] matrixReshape(int[][] nums, int r, int c) {
        if(r*c != nums.length*nums[0].length)
            return nums;
        int [][] res = new int[r][c];
        for(int i=0; i<r; i++){
            for(int j=0; j<c; j++){
                int n = i*c + j + 1;
                if(n%nums[0].length == 0)
                    res[i][j] = nums[n/nums[0].length-1][nums[0].length-1];
                else
                    res[i][j] = nums[n/nums[0].length][n%nums[0].length-1];
            }
        }
        return res;
    }

    public int[][] matrixReshape1(int[][] nums, int r, int c) {
        if(r*c != nums.length*nums[0].length)
            return nums;
        int [][] res = new int[r][c];
        int a=nums.length, b=nums[0].length, count=0;
        for(int i=0; i<r; i++){
            for(int j=0; j<c; j++, count++){
                if(count%b == 0)
                    res[i][j] = nums[count/b-1][b-1];
                else
                    res[i][j] = nums[count/b][count%b-1];
            }
        }
        return res;
    }


    class Solution {
        public int[][] matrixReshape(int[][] mat, int r, int c) {
            int row=mat.length;
            int col=mat[0].length;
            if(r*c != row * col){
                return mat;
            }
            int [][]res = new int[r][c];
            //初始化行
            int a = 0;
            //初始化列
            int b=0;

            for(int i=0;i<row;i++){
                for(int j=0;j<col ; j++){
                    if(b >=c ){
                        b=0;
                        res[++a][b++]= mat[i][j];
                    }else{
                        res[a][b++]=mat[i][j];
                    }
                }
            }
            return res;
        }
    }

    public int[][] matrixReshape2(int[][] nums, int r, int c) {

        if(nums==null) return null;
        if(r*c!=nums.length*nums[0].length)return nums;
        if(r==nums.length)return nums;

        int[][] res= new int[r][c];
        int a=0;
        int b=0;
        for(int[] i:nums){
            for(int j:i)
            {
                res[a][b]=j;
                b++;
                if(b==c){
                    b=0;
                    a++;
                }
            }

        }
        return res;
    }
}
