package com.leetcode.practice.Test20190919;

/**
 * @Author: liu qinchang
 * @Description: 广度遍历
 * @Date: Created in 9:36 19/9/19
 * @Param:
 * @return
 **/

import sun.reflect.generics.tree.Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 给定一个二叉树，返回其按层次遍历的节点值。 （即逐层地，从左到右访问所有节点）。
 *
 * 例如:
 * 给定二叉树: [3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回其层次遍历结果：
 *
 * [
 *   [3],
 *   [9,20],
 *   [15,7]
 * ]
 *
 */

public class Test_102 {
    public List<List<Integer>> levelOrder(TreeNode root) {

        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> ll = new ArrayList<>();
        List<Integer> l = new ArrayList<Integer>();
        if(root == null){
            return ll;
        }
        queue.offer(root);
        l.add(root.val);
        ll.add(l);

        while(!queue.isEmpty()){
            int level_size = queue.size();
            List<Integer> r = new ArrayList<>();
            for(int i = 0;i<level_size;i++){
                TreeNode node = queue.poll();
                if(node.left != null && node.right != null){
                    r.add(node.left.val);
                    r.add(node.right.val);
                    queue.offer(node.left);
                    queue.offer(node.right);
                }
                else if(node.left == null && node.right != null){
                    r.add(node.right.val);
                    queue.offer(node.right);
                }
                else if(node.left != null && node.right == null){
                    r.add(node.left.val);
                    queue.offer(node.left);
                }
            }
            if(r.size() != 0)
                ll.add(r);
        }
        return ll;
    }

}
