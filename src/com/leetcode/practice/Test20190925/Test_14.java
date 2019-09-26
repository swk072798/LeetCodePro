package com.leetcode.practice.Test20190925;

/**
 * @Author: liu qinchang
 * @Description:
 * @Date: Created in 14:43 19/9/25
 * @Param:
 * @return
 **/

/**
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 *
 * 如果不存在公共前缀，返回空字符串 ""。
 *
 * 示例 1:
 *
 * 输入: ["flower","flow","flight"]
 * 输出: "fl"
 * 示例 2:
 *
 * 输入: ["dog","racecar","car"]
 * 输出: ""
 * 解释: 输入不存在公共前缀。
 *
 */

/**
 * 这种解法超内存了，但是思路应该是没错的
 */
public class Test_14 {
    public String longestCommonPrefix(String[] strs) {
        StringBuffer common = new StringBuffer();

        int j = 0;
        int k = 0;
        while(j < Math.min(strs[0].length(),strs[1].length()) && k < Math.min(strs[0].length(),strs[1].length())){
            if(strs[0].charAt(j) == strs[1].charAt(k)){
                common.append(strs[0].charAt(j));
            }
            else{
                break;
            }
        }
        String strCommon = common.toString();
        for(int i = 2; i < strs.length; i++){
            int m = 0;
            int n = 0;
            while(m < Math.min(strCommon.length(),strs[i].length()) && n < Math.min(strCommon.length(),strs[i].length())){
                if(strCommon.charAt(m) == strs[i].charAt(n)){
                    m++;
                    n++;
                }
                else{
                    strCommon = strCommon.substring(0,m+1);
                    break;
                }
            }
        }
        return strCommon;
    }

    /**
     * 答案里给出的一种解法
     *
     * public String longestCommonPrefix(String[] strs) {
     *    if (strs.length == 0) return "";
     *    String prefix = strs[0];
     *    for (int i = 1; i < strs.length; i++)
     *        while (strs[i].indexOf(prefix) != 0) {
     *            prefix = prefix.substring(0, prefix.length() - 1);
     *            if (prefix.isEmpty()) return "";
     *        }
     *    return prefix;
     *}
     *使用indexOf不断扫描，然后不断减少prefix的长度，也是比较巧妙的
     */
}
