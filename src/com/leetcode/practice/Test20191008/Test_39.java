package com.leetcode.practice.Test20191008;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * @Author: liu qinchang
 * @Description:
 * @Date: Created in 13:30 19/10/8
 * @Param:
 * @return
 **/

/**
 * 给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 *
 * candidates 中的数字可以无限制重复被选取。
 *
 * 说明：
 *
 * 所有数字（包括 target）都是正整数。
 * 解集不能包含重复的组合。 
 * 示例 1:
 *
 * 输入: candidates = [2,3,6,7], target = 7,
 * 所求解集为:
 * [
 *   [7],
 *   [2,2,3]
 * ]
 * 示例 2:
 *
 * 输入: candidates = [2,3,5], target = 8,
 * 所求解集为:
 * [
 *   [2,2,2,2],
 *   [2,3,3],
 *   [3,5]
 * ]
 *
 */


/**
 * 第一种思路，按照求子集的方法做的，这样的方法不能重复使用数组中的元素，不适用本题，方法没有错
 */
public class Test_39 {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        findZuHe(0, candidates, target, result, list);
        return result;
    }
    public void findZuHe(int begin, int[] candidates, int target, List<List<Integer>> result,List<Integer> tmp){
        if(sum(tmp) == target){
            result.add(new ArrayList<>(tmp));
        }
        for(int i = begin; i < candidates.length; i++){
            tmp.add(candidates[i]);
            findZuHe(i + 1, candidates, target, result, tmp);
            tmp.remove(tmp.size() - 1);
        }
    }
    public int sum(List<Integer> tmp){
        int sum = 0;
        for(int i = 0; i < tmp.size(); i++){
            sum += tmp.get(i);
        }
        return sum;
    }
}

/**
 * 这种方法会出现重复元素的组合，比如{2,2,3},{2,3,2}这种，还没想到怎么过滤
 *
 * 问题已经解决，给结果数组排序，然后就可以去重
 */
class Solution{
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        findZuHe(candidates, target, result, list);
        return result;
    }

    public void findZuHe(int[] candidates, int target, List<List<Integer>> result, List<Integer> list){
        if(target == 0){
            List<Integer> mid_list = new ArrayList<>(list);
            mid_list.sort(new Comparator<Integer>() {       //去重
                @Override
                public int compare(Integer o1, Integer o2) {
                    return o1 < o2? -1 : 1;
                }
            });
            System.out.println(mid_list.toString());
            if(!result.contains(mid_list)){
                result.add(new ArrayList<>(mid_list));
            }
        }
        if(target < 0){
            return;
        }
        for(int i = 0; i < candidates.length; i++){
            target -= candidates[i];
            list.add(candidates[i]);
            findZuHe(candidates, target, result, list);
            target += candidates[i];
            list.remove(list.size() - 1);
        }
    }
}