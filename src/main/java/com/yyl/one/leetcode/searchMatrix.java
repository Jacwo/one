package Array;

/**
 * 编写一个高效的算法来判断 m x n 矩阵中，是否存在一个目标值。该矩阵具有如下特性：
 *
 * 每行中的整数从左到右按升序排列。
 * 每行的第一个整数大于前一行的最后一个整数。
 * 输入：matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
 * 输出：true
 * Created by yyl on 2021/6/23.
 */
public class searchMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return false;
        int n = matrix[0].length - 1;
        for(int i=0; i<matrix.length; i++){
            if(matrix[i][n] >= target){
                for(int j=0; j<=n; j++){
                    if(matrix[i][j] == target)
                        return true;
                }
                break;
            }
        }
        return false;
    }


    class Solution {
        public boolean searchMatrix(int[][] matrix, int target) {
            int row=0;
            for(int i=0;i<matrix.length;i++){
                if(matrix[i][0]<=target){
                    row=i;
                }
            }
            for(int j=0;j<matrix[row].length;j++){
                if(matrix[row][j]==target){
                    return true;
                }
            }
            return false;
        }
    }


    public boolean searchMatrix1(int[][] matrix, int target) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return false;
        int row_num = matrix.length;
        int col_num = matrix[0].length;

        int begin = 0, end = row_num * col_num - 1;

        while(begin <= end){
            int mid = (begin + end) / 2;
            int mid_value = matrix[mid/col_num][mid%col_num];

            if( mid_value == target){
                return true;

            }else if(mid_value < target){
                //Should move a bit further, otherwise dead loop.
                begin = mid+1;
            }else{
                end = mid-1;
            }
        }

        return false;
    }
}
