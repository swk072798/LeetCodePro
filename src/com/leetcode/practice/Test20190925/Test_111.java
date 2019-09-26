package com.leetcode.practice.Test20190925;

import sun.reflect.generics.tree.Tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author: liu qinchang
 * @Description: 广度优先遍历
 * @Date: Created in 10:12 19/9/25
 * @Param:
 * @return
 **/

/**
 * 给定一个二叉树，找出其最小深度。
 *
 * 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
 *
 * 说明: 叶子节点是指没有子节点的节点。
 *
 * 示例:
 *
 * 给定二叉树 [3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回它的最小深度  2.
 *
 */

 class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
 }

public class Test_111 {
    public int minDepth(TreeNode root) {
        if(root == null){
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int count = 0;
        System.out.println(queue.size());

        while(!queue.isEmpty()){
            int size = queue.size();
            count ++;
            for(int i = 0; i < size; i++){
                TreeNode tn = queue.poll();
                if(tn.left == null && tn.right == null){
                    return count;
                }
                if(tn.left != null && tn.right != null){

                    queue.offer(tn.left);
                    queue.offer(tn.right);
                }
                if(tn.left == null){
                    queue.add(tn.right);
                }
                if(tn.right == null){
                    queue.add(tn.left);
                }

            }
        }
        return count;
    }
}
