package com.leetcode.practice.Test20190918;

/**
 * @Author: liu qinchang
 * @Description: 动态规划
 * @Date: Created in 9:45 19/9/18
 * @Param:
 * @return
 **/

/**
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 *
 * 示例 1：
 *
 * 输入: "babad"
 * 输出: "bab"
 * 注意: "aba" 也是一个有效答案。
 *
 * 示例 2：
 *
 * 输入: "cbbd"
 * 输出: "bb"
 *
 */


/**
 * 中心扩展法
 * 需要判断奇偶串
 * 偶数串时会出问题
 */

public class Test_5 {

    public String longestPalindrome(String s){
        if(s.length() == 1 || s.length() == 0){
            return s;
        }
        String [] ss = s.split("");
        if(s.length() == 2){
            if(ss[0].equals(ss[1])){
                return s;
            }
        }
        String max_huiwen = new String();
        int max_len_huiwen = 0;

        for(int i = 1;i < ss.length-1; i++){
            int l = i - 1;
            int r = i + 1;
            while(l >=0 && r <= ss.length-1){
                if(ss[l].equals(ss[r])){
                    l --;
                    r ++;
                }
                else{
                    break;
                }
            }
            if((r-1) - (l+1) == 0){
                if(ss[l].equals(ss[i])){
                    max_huiwen = s.substring(l,i+1);
                    max_len_huiwen = 2;
                }
                else if(ss[i].equals(ss[r])){
                    max_huiwen = s.substring(i , r+1);
                    max_len_huiwen = 2;
                }
            }
            if((r-1) - (l+1) > max_len_huiwen){
                max_huiwen = s.substring(l + 1,r);
                max_len_huiwen = (r-1) - (l+1);
            }
        }
        if(max_len_huiwen == 0){
            return s.substring(0,1);
        }

        return max_huiwen;
    }
}
