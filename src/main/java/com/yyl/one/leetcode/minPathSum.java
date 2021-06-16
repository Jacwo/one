package com.yyl.one.leetcode;

/**
 * 给定一个包含非负整数的 m x n 网格 grid ，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
 *
 * 说明：每次只能向下或者向右移动一步。
 * 示例 1：
 * 动态规划
 * 转移方程 dp[i][j]=dp[i][j-1]+dp[i][j]
 * dp[i][j]=dp[i-1][j]+dp[i][j]
 * dp[i][j]=Math.min(dp[i-1][j],dp[i][j-1])+dp[i][j]
 * 输入：grid = [[1,3,1],[1,5,1],[4,2,1]]
 * 输出：7
 * 解释：因为路径 1→3→1→1→1 的总和最小。
 * Created by yyl on 2021/05/24.
 */
public class minPathSum {
    public int minPathSum(int[][] grid) {
        for(int i=0; i<grid[0].length; i++)
            for(int j=0; j<grid.length; j++){
                if(i == 0 && j != 0)
                    grid[j][i] += grid[j-1][i];
                else if(j == 0 && i != 0)
                    grid[j][i] += grid[j][i-1];
                else
                    grid[j][i] += Math.min(grid[j-1][i], grid[j][i-1]);
            }
        return grid[grid.length-1][grid[0].length-1];
    }

    class Solution {
        public int minPathSum(int[][] grid) {
            for(int i = 0; i < grid.length; i++) {
                for(int j = 0; j < grid[0].length; j++) {
                    if(i == 0 && j == 0) continue;
                    else if(i == 0)  grid[i][j] = grid[i][j - 1] + grid[i][j];
                    else if(j == 0)  grid[i][j] = grid[i - 1][j] + grid[i][j];
                    else grid[i][j] = Math.min(grid[i - 1][j], grid[i][j - 1]) + grid[i][j];
                }
            }
            return grid[grid.length - 1][grid[0].length - 1];
        }
    }


    public int minPathSum1(int[][] grid) {
        int[][] memo = new int[grid.length][grid[0].length];
        return minPathSumHelper(grid, 0, 0, memo);
    }

    public int minPathSumHelper(int[][] grid, int row, int col, int[][] memo) {
        if(row == grid.length-1 && col == grid[0].length-1) return grid[row][col];
        if(memo[row][col] != 0) return memo[row][col];

        int rowInc = Integer.MAX_VALUE, colInc = Integer.MAX_VALUE;
        if(row < grid.length-1) rowInc = minPathSumHelper(grid, row+1, col, memo);
        if(col < grid[0].length-1) colInc = minPathSumHelper(grid, row, col+1, memo);
        memo[row][col] = Math.min(rowInc, colInc) + grid[row][col];
        return memo[row][col];
    }
}
