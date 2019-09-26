package com.leetcode.practice.Test20190926;

/**
 * @Author: liu qinchang
 * @Description:
 * @Date: Created in 11:36 19/9/26
 * @Param:
 * @return
 **/

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
 *
 * 说明：解集不能包含重复的子集。
 *
 * 示例:
 *
 * 输入: nums = [1,2,3]
 * 输出:
 * [
 *   [3],
 *   [1],
 *   [2],
 *   [1,2,3],
 *   [1,3],
 *   [2,3],
 *   [1,2],
 *   []
 * ]
 *
 */
public class Test_78 {

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ll = new ArrayList<>();
//        ArrayList<Integer> list = new ArrayList<>();
        backtrack(0,nums,ll,new ArrayList<>());
        return ll;
    }

    public void backtrack(int i, int[] nums, List<List<Integer>> res, ArrayList<Integer> tmp){
        res.add(new ArrayList<>(tmp));
        for(int j = i; j < nums.length; j++){
            tmp.add(nums[j]);
            backtrack(j + 1,nums,res,tmp);
            tmp.remove(tmp.size() -1);
        }
    }
}
