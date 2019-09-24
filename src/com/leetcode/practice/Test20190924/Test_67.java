package com.leetcode.practice.Test20190924;

/**
 * @Author: liu qinchang
 * @Description: 字符串
 * @Date: Created in 16:03 19/9/24
 * @Param:
 * @return
 **/

/**
 * 给定两个二进制字符串，返回他们的和（用二进制表示）。
 *
 * 输入为非空字符串且只包含数字 1 和 0。
 *
 * 示例 1:
 *
 * 输入: a = "11", b = "1"
 * 输出: "100"
 * 示例 2:
 *
 * 输入: a = "1010", b = "1011"
 * 输出: "10101"
 *
 */
public class Test_67 {
    public String addBinary(String a, String b) {
        StringBuffer result = new StringBuffer();
        if(a.length() != b.length()){
            StringBuffer sb = new StringBuffer(b.length()<a.length() ? b : a);
            while(sb.length() != Math.max(a.length(),b.length())){
                sb.insert(0,"0");
            }
            if(a.length() < b.length()){
                a = sb.toString();
            }
            else if(a.length() > b.length()){
                b = sb.toString();
            }
        }
        int ca = 0;
        for(int i = a.length() - 1,j = b.length() - 1; i >= 0 && j >= 0; i--,j--){
            if(ca == 0){
                if(((a.charAt(i) - '0') + (b.charAt(j) - '0')) == 0){
                    result.insert(0,'0');
                }
                else if(((a.charAt(i) - '0') + (b.charAt(j) - '0')) == 1){

                    result.insert(0,'1');
                }
                else if(((a.charAt(i) - '0') + (b.charAt(j) - '0')) == 2){
                    ca = 1;
                    result.insert(0,'0');
                }
            }
            else{
                if(((a.charAt(i) - '0') + (b.charAt(j) - '0')) == 0){
                    result.insert(0,'1');
                    ca = 0;
                }
                else if(((a.charAt(i) - '0') + (b.charAt(j) - '0')) == 1){
                    result.insert(0,'0');
                }
                else if(((a.charAt(i) - '0') + (b.charAt(j) - '0')) == 2){
                    result.insert(0,'1');
                }
            }
        }
        if(ca == 1){
            result.insert(0,'1');
        }
        return result.toString();
    }
}
