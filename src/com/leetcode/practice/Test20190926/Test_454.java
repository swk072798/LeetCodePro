package com.leetcode.practice.Test20190926;

import java.util.HashMap;
import java.util.HashSet;

/**
 * @Author: liu qinchang
 * @Description:
 * @Date: Created in 10:17 19/9/26
 * @Param:
 * @return
 **/

/**
 * 给定四个包含整数的数组列表 A , B , C , D ,计算有多少个元组 (i, j, k, l) ，使得 A[i] + B[j] + C[k] + D[l] = 0。
 *
 * 为了使问题简单化，所有的 A, B, C, D 具有相同的长度 N，且 0 ≤ N ≤ 500 。所有整数的范围在 -228 到 228 - 1 之间，最终结果不会超过 231 - 1 。
 *
 * 例如:
 *
 * 输入:
 * A = [ 1, 2]
 * B = [-2,-1]
 * C = [-1, 2]
 * D = [ 0, 2]
 *
 * 输出:
 * 2
 *
 * 解释:
 * 两个元组如下:
 * 1. (0, 0, 0, 1) -> A[0] + B[0] + C[0] + D[1] = 1 + (-2) + (-1) + 2 = 0
 * 2. (1, 1, 0, 0) -> A[1] + B[1] + C[0] + D[0] = 2 + (-1) + (-1) + 0 = 0
 *
 */
public class Test_454 {
    int sum = 0;
    /**
     * 第一种超级无敌暴力法，指定超时
     */
//    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
//        if(A.length == 0 || B.length == 0 || C.length == 0 || D.length == 0){
//            return 0;
//        }
//        int count = 0;
//        for(int i = 0; i < A.length;i++){
//            for(int j = 0; j < B.length; j++){
//                for(int k = 0; k < C.length; k++){
//                    for(int m = 0; m < D.length; m++){
//                        if(A[i] + B[j] + C[k] + D[m] == 0){
//                            count ++;
//                        }
//                    }
//                }
//            }
//        }
//        return count;
//    }

    /**
     *利用hashmap记录C和D中的值和每个值出现的次数，再从A和B中寻找HashMap中值的倒数
     */
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        if(A.length == 0 || B.length == 0 || C.length == 0 || D.length == 0){
            return 0;
        }
        int count = 0;
        HashMap<Integer,Integer> hm = new HashMap<>();
        for(int i = 0; i < C.length; i++){
            for(int j = 0; j < D.length; j++){
                if(hm.containsKey(C[i] + D[j])){
                    hm.put(C[i] + D[j], hm.get(C[i] + D[j]) + 1);
                }
                else{
                    hm.put(C[i] + D[j], 1);
                }
            }
        }
        for(int m = 0; m < A.length;m++){
            for(int n = 0; n < B.length; n++){
                int res = -(A[m] + B[n]);
                if(hm.containsKey(res)){
                    count += hm.get(res);
                }
            }
        }
        return count;

    }

}
