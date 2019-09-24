package com.leetcode.practice.Test20190924;

/**
 * @Author: liu qinchang
 * @Description: 动态规划
 * @Date: Created in 10:13 19/9/24
 * @Param:
 * @return
 **/

/**
 *给定字符串 s 和 t ，判断 s 是否为 t 的子序列。
 *
 * 你可以认为 s 和 t 中仅包含英文小写字母。字符串 t 可能会很长（长度 ~= 500,000），而 s 是个短字符串（长度 <=100）。
 *
 * 字符串的一个子序列是原始字符串删除一些（也可以不删除）字符而不改变剩余字符相对位置形成的新字符串。（例如，"ace"是"abcde"的一个子序列，而"aec"不是）。
 *
 * 示例 1:
 * s = "abc", t = "ahbgdc"
 *
 * 返回 true.
 *
 * 示例 2:
 * s = "axc", t = "ahbgdc"
 *
 * 返回 false.
 */

public class Test_392 {
    public boolean isAllZero(int []num){
        for(int i = 0; i < num.length; i++){
            if(num[i] == 1){
                return false;
            }
        }
        return true;
    }
    public boolean isSubsequence(String s, String t) {
        int[][] dp = new int[s.length()][t.length()];
        int pre_index = 0;
        for(int i = 0; i < s.length(); i++){
            for(int j = 0; j < t.length();j++){
                if(s.charAt(i) == t.charAt(j) && j > pre_index){
                    dp[i][j] = 1;
                    pre_index = j;
                }
            }
        }

         for(int i = 0; i < s.length(); i++){
             if(isAllZero(dp[i])){
                 return false;
             }
         }
         return true;
    }
}
