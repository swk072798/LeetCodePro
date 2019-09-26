package com.leetcode.practice.Test20190925;

/**
 * @Author: liu qinchang
 * @Description:
 * @Date: Created in 10:43 19/9/25
 * @Param:
 * @return
 **/
public class Test_35 {
    public int searchInsert(int[] nums, int target) {
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == target){
                return i;
            }
        }
        for(int j = 0; j < nums.length - 1; j++){
            if(nums[j] < target && nums[j + 1] > target){
                return j + 1;
            }
        }
        if(nums[0] > target){
            return 0;
        }
        if(nums[nums.length - 1] <  target){
            return nums.length;
        }
        return 0;
    }
}
