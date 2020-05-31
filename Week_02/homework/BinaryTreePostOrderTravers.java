package com.algorithm.secondweek.homework;

import java.util.*;

/**
 * 后序遍历 ： 左 - 右 - 根
 * https://leetcode-cn.com/problems/binary-tree-postorder-traversal/solution/er-cha-shu-de-hou-xu-bian-li-by-leetcode/
 */
public class BinaryTreePostOrderTravers {

    public static void main(String[] args) {

    }

    public List<Integer> postOrderIteration(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        postOrderIteration(root, res);
        return res;
    }

    public void postOrderIteration(TreeNode root, List<Integer> res) {
        if (null == root) {
            return;
        }
        if (null != root.left) {
            postOrderIteration(root.left, res);
        }
        if (null != root.right) {
            postOrderIteration(root.right, res);
        }

        res.add(root.val);
    }

    /**
     *  时间复杂度：访问每个节点恰好一次，因此时间复杂度为 O(N)，其中 N 是节点的个数，也就是树的大小。
     * 空间复杂度：取决于树的结构，最坏情况需要保存整棵树，因此空间复杂度为 O(N)。
     * @param root
     * @return
     */
    public List<Integer> postOrderIteration1(TreeNode root) {

        LinkedList<Integer> res = new LinkedList<>();
        if (null == root) {
            return res;
        }
        LinkedList<TreeNode> stack = new LinkedList<>();
        stack.add(root);
        while (!stack.isEmpty()) {
            TreeNode curr = stack.pollLast();
            res.addFirst( curr.val);
            if (null != curr.left) {
                stack.push(curr.left);
            }
            if (null != curr.right) {
                stack.push(curr.right);
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
