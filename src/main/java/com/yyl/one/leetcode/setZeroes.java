package com.yyl.one.leetcode;

/**
 * 给定一个 m x n 的矩阵，如果一个元素为 0 ，则将其所在行和列的所有元素都设为 0 。请使用 原地 算法。
 *
 * 进阶：
 *
 * 一个直观的解决方案是使用  O(mn) 的额外空间，但这并不是一个好的解决方案。
 * 一个简单的改进方案是使用 O(m + n) 的额外空间，但这仍然不是最好的解决方案。
 * 你能想出一个仅使用常量空间的解决方案吗？
 *  
 * 示例 1：
 * 输入：matrix = [[1,1,1],[1,0,1],[1,1,1]]
 * 输出：[[1,0,1],[0,0,0],[1,0,1]]
 * https://leetcode-cn.com/problems/set-matrix-zeroes
 * Created by yyl on 2021/6/23.
 */
public class setZeroes {
    public void setZeroes(int[][] matrix) {
        int[] row = new int[matrix.length];
        int[] col = new int[matrix[0].length];
        for(int i=0; i<matrix.length; i++)
            for(int j=0; j<matrix[0].length; j++)
                if(matrix[i][j] == 0) {
                    row[i] = 1;
                    col[j] = 1;
                }
        for(int i=0; i<matrix.length; i++){
            if(row[i] == 1){
                for(int j=0; j<matrix[0].length; j++)
                    matrix[i][j] = 0;
            }
        }
        for(int i=0; i<matrix[0].length; i++){
            if(col[i] == 1){
                for(int j=0; j<matrix.length; j++)
                    matrix[j][i] = 0;
            }
        }
    }

    public void setZeroes1(int[][] matrix) {
        boolean fr = false,fc = false;
        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[0].length; j++) {
                if(matrix[i][j] == 0) {
                    if(i == 0) fr = true;
                    if(j == 0) fc = true;
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                }
            }
        }
        for(int i = 1; i < matrix.length; i++) {
            for(int j = 1; j < matrix[0].length; j++) {
                if(matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }
        if(fr) {
            for(int j = 0; j < matrix[0].length; j++) {
                matrix[0][j] = 0;
            }
        }
        if(fc) {
            for(int i = 0; i < matrix.length; i++) {
                matrix[i][0] = 0;
            }
        }

    }
}
