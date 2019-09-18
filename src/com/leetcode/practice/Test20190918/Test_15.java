package com.leetcode.practice.Test20190918;

/**
 * @Author: liu qinchang
 * @Description:  数组问题
 * @Date: Created in 9:22 19/9/18
 * @Param:
 * @return
 **/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * 给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？找出所有满足条件且不重复的三元组。
 *
 * 注意：答案中不可以包含重复的三元组。
 *
 * 例如, 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
 *
 * 满足要求的三元组集合为：
 * [
 *   [-1, 0, 1],
 *   [-1, -1, 2]
 * ]
 *
 */

/**
 * 无情的超时了
 */
public class Test_15 {

    public List<List<Integer>> threeSum(int[] nums){

        List<List<Integer>> result = new ArrayList<>();
        if(nums.length < 3){
            return result;
        }
        Arrays.sort(nums);
        for(int j = 0; j < nums.length-2; j++){
            for(int k = j+1 ;k < nums.length-1; k++){
                for(int m = k+1 ; m < nums.length; m++){
                    if(nums[j] + nums[k] + nums[m] == 0){
                        List<Integer> l = new ArrayList<>();
                        l.add(nums[j]);
                        l.add(nums[k]);
                        l.add(nums[m]);
                        if(!result.contains(l)){    //这个地方的去重这么弄复杂度太大了
                            result.add(l);
                        }

                    }
                }
            }
        }
        return result;
    }

}

