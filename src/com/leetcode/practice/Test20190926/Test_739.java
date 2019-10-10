package com.leetcode.practice.Test20190926;

/**
 * @Author: liu qinchang
 * @Description:
 * @Date: Created in 9:21 19/9/26
 * @Param:
 * @return
 **/

/**
 * 根据每日 气温 列表，请重新生成一个列表，对应位置的输入是你需要再等待多久温度才会升高超过该日的天数。如果之后都不会升高，请在该位置用 0 来代替。
 *
 * 例如，给定一个列表 temperatures = [73, 74, 75, 71, 69, 72, 76, 73]，你的输出应该是 [1, 1, 4, 2, 1, 1, 0, 0]。
 *
 * 提示：气温 列表长度的范围是 [1, 30000]。每个气温的值的均为华氏度，都是在 [30, 100] 范围内的整数。
 *
 *
 *
 */

/**
 * 解法没错，会超时，答案解析中说道可以将中间遍历的过程改为逆序遍历，从右向左遍历整个数组
 */
public class Test_739 {
    public int[] dailyTemperatures(int[] T) {
        int j = 1;
        int[] a = new int[T.length];

        for(int i = 0;i < T.length - 1;i++){

            while(i+j < T.length && T[i] >= T[i+j]){
                j++;
            }
            System.out.println(i+" "+j);
            if(i + j == T.length){
                a[i] = 0;
            }
            else{
                a[i] = j;
            }

            j = 1;
        }
        a[a.length -1] = 0;
        return a;
    }
}
