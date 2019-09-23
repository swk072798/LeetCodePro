package com.leetcode.practice.Test20190923;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Author: liu qinchang
 * @Description: 深度优先
 * @Date: Created in 9:30 19/9/23
 * @Param:
 * @return
 **/

/**
 * 给定一个二叉树，返回其节点值自底向上的层次遍历。 （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历）
 *
 * 例如：
 * 给定二叉树 [3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回其自底向上的层次遍历为：
 *
 * [
 *   [15,7],
 *   [9,20],
 *   [3]
 * ]
 *
 */
public class Test_107 {

    public List<List<Integer>> levelOrderBottom(TreeNode root) {

        List<List<Integer>> listList = new LinkedList<>();
        if(root == null){
            return listList;
        }
        Queue<TreeNode> queue = new LinkedList();
        queue.add(root);
        while(!queue.isEmpty()){
            int ceng = queue.size();
            List<Integer> list = new ArrayList<>();
            for(int i = 0; i < ceng; i++){
                if (queue.peek().left != null ) {
                    queue.offer(queue.peek().left);
                }
                if( queue.peek().right != null){
                    queue.offer(queue.peek().right);
                }
                if (queue.peek() != null){
                    list.add(queue.poll().val);
                }
                else{
                    queue.poll();
                }
            }
            listList.add(0,list);
        }
        return listList;

    }
}
