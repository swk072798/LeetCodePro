package com.leetcode.practice.Test20190919;

/**
 * @Author: liu qinchang
 * @Description:
 * @Date: Created in 10:17 19/9/19
 * @Param:
 * @return
 **/

/**
 * 给定一个二叉树，找到最长的路径，这个路径中的每个节点具有相同值。 这条路径可以经过也可以不经过根节点。
 *
 * 注意：两个节点之间的路径长度由它们之间的边数表示。
 *
 * 示例 1:
 *
 * 输入:
 *
 *               5
 *              / \
 *             4   5
 *            / \   \
 *           1   1   5
 * 输出:
 *
 * 2
 *
 * 示例 2:
 *
 * 输入:
 *
 *               1
 *              / \
 *             4   5
 *            / \   \
 *           4   4   5
 * 输出:
 *
 * 2
 */

/**
 * 有点难度，写的还不太好，终归是要回到根节点，需要再研究一下题解
 */
public class Test_687 {
    int count = 0;
    int max_count = 0;
    public int longestUnivaluePath(TreeNode root) {
        if(root == null){
            if(count > max_count){
                max_count = count;
                return max_count;
            }
            return max_count;
        }

        if(root.left.val == root.right.val){
            count ++;
            longestUnivaluePath(root.left);
        }
        if(root.right != null && root.right.val == root.val){
            count ++;
            longestUnivaluePath(root.right);
        }

        count --;

        return max_count - 1;
    }
}
