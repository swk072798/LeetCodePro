package com.leetcode.practice.Test20190926;

/**
 * @Author: liu qinchang
 * @Description:
 * @Date: Created in 11:13 19/9/26
 * @Param:
 * @return
 **/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 先看78题 子集I
 *
 * 给定一个可能包含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
 *
 * 说明：解集不能包含重复的子集。
 *
 * 示例:
 *
 * 输入: [1,2,2]
 * 输出:
 * [
 *   [2],
 *   [1],
 *   [1,2,2],
 *   [2,2],
 *   [1,2],
 *   []
 * ]
 *
 */
public class Test_90 {

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);      //一定要先将数组排序，不然子集中会出现[1,2],[2,1]这种情况，并且难以去重
        findSub(0,nums,new ArrayList<>(),result);
        return result;
    }

    public void findSub(int begin, int[] nums, List<Integer> list, List<List<Integer>> result){
        if(!result.contains(list)){
            result.add(new ArrayList<>(list));
        }       //若结果及中不包含当前子集，则加入到结果集中
        for(int i = begin; i < nums.length; i++){
            list.add(nums[i]);
            findSub(i + 1, nums, list, result);
            list.remove(list.size() - 1);
        }
    }
}
