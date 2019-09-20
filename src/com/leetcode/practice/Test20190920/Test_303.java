package com.leetcode.practice.Test20190920;

/**
 * @Author: liu qinchang
 * @Description:
 * @Date: Created in 10:06 19/9/20
 * @Param:
 * @return
 **/

/**
 * 给定一个整数数组  nums，求出数组从索引 i 到 j  (i ≤ j) 范围内元素的总和，包含 i,  j 两点。
 *
 * 示例：
 *
 * 给定 nums = [-2, 0, 3, -5, 2, -1]，求和函数为 sumRange()
 *
 * sumRange(0, 2) -> 1
 * sumRange(2, 5) -> -1
 * sumRange(0, 5) -> -3
 * 说明:
 *
 * 你可以假设数组不可变。
 * 会多次调用 sumRange 方法。
 *
 */
public class Test_303 {
}

/**
 * 这道题太简单了，网上说太多次的调用sumRange还是会超时，可以用hashmap存储每次调用的结果，然后在每次计算之前查一下map
 *
 * 网页上过了就行
 *
 */

class NumArray {

    private int[] data;

    /**
     * 可以使用动态规划在构造函数里直接缓存行
     * @param nums
     */
    public NumArray(int[] nums) {
        data = nums;
    }

    public int sumRange(int i, int j) {
        int sum = 0;
        for(int k = i; k <= j; k++){
            sum += data[k];
        }
        return sum;
    }
}

/**
 *给定一个二维矩阵，计算其子矩形范围内元素的总和，该子矩阵的左上角为 (row1, col1) ，右下角为 (row2, col2)。
 *
 *
 * 上图子矩阵左上角 (row1, col1) = (2, 1) ，右下角(row2, col2) = (4, 3)，该子矩形内元素的总和为 8。
 *
 * 示例:
 *
 * 给定 matrix = [
 *   [3, 0, 1, 4, 2],
 *   [5, 6, 3, 2, 1],
 *   [1, 2, 0, 1, 5],
 *   [4, 1, 0, 1, 7],
 *   [1, 0, 3, 0, 5]
 * ]
 *
 * sumRegion(2, 1, 4, 3) -> 8
 * sumRegion(1, 1, 2, 2) -> 11
 * sumRegion(1, 2, 2, 4) -> 12
 * 说明:
 *
 * 你可以假设矩阵不可变。
 * 会多次调用 sumRegion 方法。
 * 你可以假设 row1 ≤ row2 且 col1 ≤ col2。
 *
 */

/**
 * 此题是一位数组的爸爸版，趁着上一题写的偷工减料，把这一题好好写一些
 * 构造函数中复制一个mm数组，然后使用一个dp来记录该位置之前所有元素的和
 * sumRegion中直接使用sum += (dp[i][col2] - dp[i][col1] + mm[i][col1])来读取dp中的记忆数据就行
 * 每次调用的时间复杂度为O(1)
 */

class NumMatrix {
    private int [][] mm;
    private int[][] dp;
    public NumMatrix(int[][] matrix) {
        if(matrix.length > 0){
            mm = new int[matrix.length][matrix[0].length];
            mm = matrix;
            dp = new int [matrix.length][matrix[0].length];
            for(int i = 0; i < matrix.length; i++){
                for(int j = 0; j < matrix[0].length; j++){
                    if(j == 0){
                        dp[i][j] = matrix[i][j];
                    }
                    else{
                        dp[i][j] = dp[i][j -1] + matrix[i][j];
                    }
                }
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        if(mm.length == 0 && dp.length == 0){
            return 0;
        }
        int sum = 0;
        for(int i = row1; i <= row2; i++){
            sum += (dp[i][col2] - dp[i][col1] + mm[i][col1]);
        }
        return sum;
    }
}