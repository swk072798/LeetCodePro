package com.leetcode.practice.Test20190918;

/**
 * @Author: liu qinchang
 * @Description:
 * @Date: Created in 10:39 19/9/18
 * @Param:
 * @return
 **/

import java.util.ArrayList;

/**
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 *
 * 示例 1:
 *
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 *
 * 示例 2:
 *
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 *
 * 示例 3:
 *
 * 输入: "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 *
 */

/**
 * 遇到"dvdf"时候会出现问题，有待改正
 */
public class Test_3 {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0){
            return 0;
        }
        if(s.length() == 1){
            return 1;
        }
        String[] ss = s.split("");
        ArrayList<String> al = new ArrayList<>();
        int MAX_LEN = 0;
        int j = 0;
        while(j < ss.length){
            for(int i = j;i < s.length();i++){
                if(!al.contains(ss[i])){
                    al.add(ss[i]);
                }
                else{
                    if(al.size() > MAX_LEN){
                        MAX_LEN = al.size();
                    }
                    al.clear();
                    al.add(ss[i]);
                }
                if(al.size() > MAX_LEN){
                    MAX_LEN = al.size();

                }

            }
            j ++;
        }

        return MAX_LEN;
    }
}
