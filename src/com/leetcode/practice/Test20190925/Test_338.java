package com.leetcode.practice.Test20190925;

/**
 * @Author: liu qinchang
 * @Description: 动态规划
 * @Date: Created in 11:13 19/9/25
 * @Param:
 * @return
 **/

/**
 * 给定一个非负整数 num。对于 0 ≤ i ≤ num 范围中的每个数字 i ，计算其二进制数中的 1 的数目并将它们作为数组返回。
 *
 * 示例 1:
 *
 * 输入: 2
 * 输出: [0,1,1]
 * 示例 2:
 *
 * 输入: 5
 * 输出: [0,1,1,2,1,2]
 *
 */

public class Test_338 {
    public int[] countBits(int num) {
        int[] a = new int[num + 1];
        for(int i = 1; i <= num; i++){
            int count = 0;
            int j = i;
            while(j > 0){
                if(j % 2 == 1){
                    count ++;
                    j = j / 2;
                }
                else {
                    j = j /2;
                }
            }
            a[i] = count;
        }
        return a;
    }
}
