package com.algorithm.secondweek.homework;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 二叉树的中序遍历 左 - 根 - 右
 * https://leetcode-cn.com/problems/binary-tree-inorder-traversal/
 */
public class BinaryTreeInOrderTraversal {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(100);
        inorderTraversal2(root);
    }

    /**
     * 递归
     * 时间复杂度：O(n)。递归函数 T(n)=2⋅T(n/2)+1。
     * 空间复杂度：最坏情况下需要空间O(n)，平均情况为O(logn)。
     * @param root
     * @return
     */
    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        inorderTraversal1(root, res);
        return res;
    }

    /**
     * 中序遍历： 左 - 根 - 右
     * @param root
     * @param res
     */
    private static void inorderTraversal1(TreeNode root, List<Integer> res) {
        if (null == root) {
            return;
        }

        if (null != root.left) {
            inorderTraversal1(root.left, res);
        }
        res.add(root.val);
        if (null != root.right) {
            inorderTraversal1(root.right, res);
        }
    }


    private static List<Integer> inorderTraversal2(TreeNode root)  {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;
        while (null != curr || !stack.isEmpty()) {
            while (null != curr) {
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            res.add(curr.val);
            curr = curr.right;
        }
        return res;
    }



    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

}
