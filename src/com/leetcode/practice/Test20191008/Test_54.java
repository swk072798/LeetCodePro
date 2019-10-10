package com.leetcode.practice.Test20191008;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: liu qinchang
 * @Description:
 * @Date: Created in 15:24 19/10/8
 * @Param:
 * @return
 **/

/**
 * 给定一个包含 m x n 个元素的矩阵（m 行, n 列），请按照顺时针螺旋顺序，返回矩阵中的所有元素。
 *
 * 示例 1:
 *
 * 输入:
 * [
 *  [ 1, 2, 3 ],
 *  [ 4, 5, 6 ],
 *  [ 7, 8, 9 ]
 * ]
 * 输出: [1,2,3,6,9,8,7,4,5]
 * 示例 2:
 *
 * 输入:
 * [
 *   [1, 2, 3, 4],
 *   [5, 6, 7, 8],
 *   [9,10,11,12]
 * ]
 * 输出: [1,2,3,4,8,12,11,10,9,5,6,7]
 *
 */

public class Test_54 {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        if(matrix.length == 0){
            return result;
        }
        int [][] record = new int[matrix.length][matrix[0].length];
        int left = 0;
        int right = matrix[0].length - 1;
        int top = 0;
        int bottom = matrix.length - 1;

        while(left <= right && top <= bottom){
            for(int i = left; i <= right; i++){
                if(record[top][i] == 0){
                    result.add(matrix[top][i]);
                }
                record[top][i] = 1;
            }
            for(int j = top + 1; j <= bottom; j++){
                if(record[j][right] == 0){
                    result.add(matrix[j][right]);
                }
                record[j][right] = 1;
            }
            for(int k = right -1; k >= left; k--){
                if(record[bottom][k] == 0){
                    result.add(matrix[bottom][k]);
                }
                record[bottom][k] = 1;
            }
            for(int m = bottom - 1; m > top; m--){
                if(record[m][left] == 0){
                    result.add(matrix[m][left]);
                }
                record[m][left] = 1;
            }
            left++;
            right--;
            top++;
            bottom--;
        }
        return result;
    }
}
