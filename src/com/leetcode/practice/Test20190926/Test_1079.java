package com.leetcode.practice.Test20190926;

/**
 * @Author: liu qinchang
 * @Description:
 * @Date: Created in 10:57 19/9/26
 * @Param:
 * @return
 **/

import java.util.ArrayList;
import java.util.List;

/**
 * (结合了78和90的子集问题，加上全排列的问题，两个问题的结果集的并集，组成了本题的结果集)
 *
 * 你有一套活字字模 tiles，其中每个字模上都刻有一个字母 tiles[i]。返回你可以印出的非空字母序列的数目。
 *
 *  
 *
 * 示例 1：
 *
 * 输入："AAB"
 * 输出：8
 * 解释：可能的序列为 "A", "B", "AA", "AB", "BA", "AAB", "ABA", "BAA"。
 * 示例 2：
 *
 * 输入："AAABBC"
 * 输出：188
 *
 */

/**
 * 集合了数组问题和全排列问题
 *
 * 验证时出了点错，少了一些子集和排列，还在找问题，思路没错
 */

public class Test_1079 {

    public int numTilePossibilities(String tiles) {
        String[] str = tiles.split("");
        List<List<String>> result = new ArrayList<>();
        findAllSub(0, str, result, new ArrayList<>());
        findAllPaiLie(0, 0, str, result);
        for(List<String> l : result){
            for(String s : l){
                System.out.print(s);
            }
            System.out.println();
        }
        return result.size();
    }

    public void findAllSub(int begin, String[] str, List<List<String>> result, List<String> list){      //先找子集
        if(!result.contains(list)){
            result.add(new ArrayList<>(list));
        }
        for(int i = begin; i < str.length; i++){
            list.add(str[i]);
            findAllSub(i + 1, str, result, list);
            list.remove(list.size() - 1);
        }
    }

    public void findAllPaiLie(int first, int i, String[] str, List<List<String>> result){       //再找全排列
        if(i == str.length){
            return;
        }
        String[] copy_str = str;
        while(first < str.length){
            swap(copy_str, first, i);
            List<String> l = new ArrayList<>();
            for(int k = 0;k < copy_str.length; k++){
                l.add(copy_str[k]);
            }
            if(!result.contains(l)){
                result.add(l);
            }
            first ++;
        }
        findAllPaiLie(0,++i,str,result);
    }
    public void swap(String[] str, int i, int j){
        String temp = str[i];
        str[i] = str[j];
        str[j] = temp;
    }
}
