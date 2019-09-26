package com.leetcode.practice.Test20190925;

/**
 * @Author: liu qinchang
 * @Description:
 * @Date: Created in 11:42 19/9/25
 * @Param:
 * @return
 **/


/**
 * 给定一个单链表，其中的元素按升序排序，将其转换为高度平衡的二叉搜索树。
 *
 * 本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。
 *
 * 示例:
 *
 * 给定的有序链表： [-10, -3, 0, 5, 9],
 *
 * 一个可能的答案是：[0, -3, 9, -10, null, 5], 它可以表示下面这个高度平衡二叉搜索树：
 *
 *       0
 *      / \
 *    -3   9
 *    /   /
 *  -10  5
 *
 * 没做出来
 */

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}



public class Test_109 {

    public TreeNode sortedListToBST(ListNode head) {
        ListNode ln1 = head;
        ListNode ln2 = head;
        while(ln2 != null){
            ln1 = ln1.next;
            ln2 = ln2.next.next;
        }

        TreeNode root = new TreeNode(ln1.val);

        return null;
    }
//    public TreeNode createTree(TreeNode root, ListNode mid){
//
//    }
}
