package com.algorithm.secondweek.homework;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 二叉树的前序遍历
 * https://leetcode-cn.com/problems/binary-tree-preorder-traversal/solution/er-cha-shu-de-qian-xu-bian-li-by-leetcode/
 */
public class BinaryTreePreOrderTraversal {


    /**
     * 前序遍历 根 - 左 - 右
     * @param root
     * @return
     */
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();

        preorderTraversal(root, res);
        return res;
    }

    public void preorderTraversal(TreeNode root, List<Integer> res) {
        if (null == root) {
            return;
        }
        res.add(root.val);
        if (null != root.left) {
            preorderTraversal(root.left, res);
        }
        if (null != root.right) {
            preorderTraversal(root.right, res);
        }

        return;
    }

    public List<Integer>  preorderTraversal1(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        if (null == root) {
            return res;
        }

        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode curr = stack.pop();
            res.add(curr.val);
            if (null != curr.right) {
                stack.push(curr.right);
            }
            if (null != curr.left) {
                stack.push(curr.left);
            }
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
