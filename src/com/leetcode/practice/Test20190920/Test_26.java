package com.leetcode.practice.Test20190920;

/**
 * @Author: liu qinchang
 * @Description:
 * @Date: Created in 9:29 19/9/20
 * @Param:
 * @return
 **/

import java.util.HashSet;

/**
 * 给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
 *
 * 不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
 *
 *
 * 示例 1:
 *
 * 给定数组 nums = [1,1,2],
 *
 * 函数应该返回新的长度 2, 并且原数组 nums 的前两个元素被修改为 1, 2。
 *
 * 你不需要考虑数组中超出新长度后面的元素。
 *
 *
 * 示例 2:
 *
 * 给定 nums = [0,0,1,1,1,2,2,3,3,4],
 *
 * 函数应该返回新的长度 5, 并且原数组 nums 的前五个元素被修改为 0, 1, 2, 3, 4。
 *
 * 你不需要考虑数组中超出新长度后面的元素。
 *
 */


public class Test_26 {

    /**
     * 首先想到的是直接用hashSet进行去重，然后求hashSet的size()就能知道重复元素有多少个，
     * 但是原题会调用入参数组的引用进行验证，也就是说必须在原数组上面进行更改。这种方法虽然简单，但是不适用于这一题
     * @param nums
     * @return
     */
//    public int removeDuplicates(int[] nums) {
//        HashSet<Integer> hashSet = new HashSet<>();
//        for(int i = 0;i<nums.length;i++){
//            System.out.println(hashSet.add(nums[i]));
//        }
//        return hashSet.size();
//    }

    /**
     * 例：nums = [1,1,2]
     * step1: i = 0, j = 1, nums = [1,1,2]
     * step2:i = 0, j = 2, nums = [1,1,2]
     * step3: i = 1,j = 2, nums = [1,2,2]
     *
     * @param nums
     * @return
     */
    public int removeDuplicates(int[] nums) {
        if(nums.length == 0){
            return 0;
        }
        int i = 0;
        for(int j = 1; j < nums.length; j++){
            if(nums[i] != nums[j]){
                i++;
                nums[i] = nums[j];
            }
        }
        return i+1;
    }
}
