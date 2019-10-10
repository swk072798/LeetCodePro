package com.leetcode.practice.Test20191009;

/**
 * @Author: liu qinchang
 * @Description:
 * @Date: Created in 13:37 19/10/9
 * @Param:
 * @return
 **/

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * 给定一个数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 *
 * candidates 中的每个数字在每个组合中只能使用一次。
 *
 * 说明：
 *
 * 所有数字（包括目标数）都是正整数。
 * 解集不能包含重复的组合。 
 * 示例 1:
 *
 * 输入: candidates = [10,1,2,7,6,1,5], target = 8,
 * 所求解集为:
 * [
 *   [1, 7],
 *   [1, 2, 5],
 *   [2, 6],
 *   [1, 1, 6]
 * ]
 * 示例 2:
 *
 * 输入: candidates = [2,5,2,1,2], target = 5,
 * 所求解集为:
 * [
 *   [1,2,2],
 *   [5]
 * ]
 *
 */
public class Test_40 {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        findSub(candidates,target,0,result,list);
        return result;
    }
    public void findSub(int[] candidates, int target, int begin, List<List<Integer>> result, List<Integer> list){
        if(sum(list) == target){
            List<Integer> mid_list = new ArrayList<>(list);
            mid_list.sort(new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    return o1 - o2;
                }
            });
            if(!result.contains(mid_list)){
                result.add(new ArrayList<>(mid_list));
            }
        }
        for(int i = begin; i < candidates.length; i++){
            list.add(candidates[i]);
            findSub(candidates,target,i + 1,result,list);
            list.remove(list.size() - 1);
        }
    }

    public int sum(List<Integer> list){
        int sum = 0;
        for(int i = 0; i < list.size(); i++){
            sum += list.get(i);
        }
        return sum;
    }
}
