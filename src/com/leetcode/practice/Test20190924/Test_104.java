package com.leetcode.practice.Test20190924;

/**
 * @Author: liu qinchang
 * @Description: 深度优先
 * @Date: Created in 17:14 19/9/24
 * @Param:
 * @return
 **/

/**
 * 给定一个二叉树，找出其最大深度。
 *
 * 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
 *
 * 说明: 叶子节点是指没有子节点的节点。
 *
 * 示例：
 * 给定二叉树 [3,9,20,null,null,15,7]，
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 */
public class Test_104 {
    int count = 0;
    int max_deep = 0;
    public int maxDepth(TreeNode root) {
        if(root == null){
            if(count > max_deep){
                max_deep = count;
            }
            return max_deep;
        }
        count ++;
        maxDepth(root.left);
        maxDepth(root.right);
        count --;

        return max_deep;
    }
}
