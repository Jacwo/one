package com.yyl.one.leetcode;

import java.util.List;

/**
 * 给定一个三角形 triangle ，找出自顶向下的最小路径和。
 *
 * 每一步只能移动到下一行中相邻的结点上。相邻的结点 在这里指的是 下标 与 上一层结点下标 相同或者等于 上一层结点下标 + 1 的两个结点。
 * 也就是说，如果正位于当前行的下标 i ，那么下一步可以移动到下一行的下标 i 或 i + 1 。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：triangle = [[2],[3,4],[6,5,7],[4,1,8,3]]
 * 输出：11
 * 解释：如下面简图所示：
 *    2
 *   3 4
 *  6 5 7
 * 4 1 8 3
 * 自顶向下的最小路径和为 11（即，2 + 3 + 5 + 1 = 11）。
 * 示例 2：
 *
 * 输入：triangle = [[-10]]
 * 输出：-10
 * Created by yyl on 2021/5/24.
 */
public class minimumTotal {
    public int minimumTotal(List<List<Integer>> triangle) {
        int row = triangle.size();
        int [] res = new int[row+1];

        for (int i=row-1; i>=0; i--){
            List<Integer> tmp = triangle.get(i);
            for(int j=0; j<tmp.size(); j++)
                res[j] = Math.min(res[j], res[j+1]) + tmp.get(j);
        }
        return res[0];
    }

    public int minimumTotal1(List<List<Integer>> triangle) {
        for(int i=triangle.size()-2; i>=0; i--)
            for(int j=0; j<=i; j++)
                triangle.get(i).set(j, triangle.get(i).get(j)+Math.min(triangle.get(i+1).get(j), triangle.get(i+1).get(j+1)));
        return triangle.get(0).get(0);
    }

    //动态规划
    public int minimumTotal2(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[][] dp = new int[n][n];
        dp[0][0] = triangle.get(0).get(0);

        for (int i=1;i<n;i++) {

            for (int j=0;j<=i;j++) {

                if (j == 0) { // 三角形的最左边

                    dp[i][j] = dp[i - 1][j] + triangle.get(i).get(j);
                } else if (j == i) { // 三角形的最右边

                    dp[i][j] = dp[i - 1][j - 1] + triangle.get(i).get(i);
                } else {

                    dp[i][j] = Math.min(dp[i - 1][j], dp[i - 1][j - 1]) + triangle.get(i).get(j);
                }
            }
        }
        // dp最后一行记录了最小路径
        int minSum = dp[n - 1][0];
        for (int i=1;i<n;i++) {

            minSum = Math.min(minSum, dp[n - 1][i]);
        }
        return minSum;

    }
}
