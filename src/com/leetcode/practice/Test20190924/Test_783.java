package com.leetcode.practice.Test20190924;

/**
 * @Author: liu qinchang
 * @Description:
 * @Date: Created in 9:30 19/9/24
 * @Param:
 * @return
 **/

import java.util.ArrayList;

/**
 * 给定一个二叉搜索树的根结点 root, 返回树中任意两节点的差的最小值。
 *
 * 示例：
 *
 * 输入: root = [4,2,6,1,3,null,null]
 * 输出: 1
 * 解释:
 * 注意，root是树结点对象(TreeNode object)，而不是数组。
 *
 * 给定的树 [4,2,6,1,3,null,null] 可表示为下图:
 *
 *           4
 *         /   \
 *       2      6
 *      / \
 *     1   3
 *
 * 最小的差值是 1, 它是节点1和节点2的差值, 也是节点3和节点2的差值。
 *
 */

 class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
 }

public class Test_783 {
     int min_result = 1000;
     ArrayList<Integer> al = new ArrayList<>();  // 这里用arrayList如果不指定初始大小，会因为扩容使得性能变慢
    public int minDiffInBST(TreeNode root) {
        if(root == null){
            return 0;
        }
        minDiffInBST(root.left);
        al.add(root.val);
        minDiffInBST(root.right);

        for(int i = 0; i < al.size() - 1; i++){
            if(al.get(i+1) - al.get(i) < min_result){
                min_result = al.get(i+1) - al.get(i);
            }
        }
        return min_result;
    }
}
