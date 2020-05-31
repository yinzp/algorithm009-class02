package com.algorithm.secondweek.homework;

import java.util.*;

/**
 * N叉树的前序遍历
 * https://leetcode-cn.com/problems/n-ary-tree-preorder-traversal/description/
 * 前序遍历：根 - 左 - 右
 */
public class NAryTreePreorderTraversal {

    public static void main(String[] args) {

    }

    /**
     * 递归实现
     * @param root
     * @return
     */
    public static List<Integer> preorder1(Node root) {
        List<Integer> res = new ArrayList<>();
        preorder1(root, res);
        return res;
    }

    public static void preorder1(Node root, List<Integer> res) {
        if (null == root) {
            return;
        }
        res.add(root.val);
        int size = root.children.size();
        for (int i = 0; i < size; i++) {
            preorder1(root.children.get(i), res);
        }
        return ;
    }

    /**
     * 迭代实现
     * @param root
     */
    private static List<Integer> preorder2(Node root){
        List<Integer> res = new ArrayList<>();
        Deque<Node> stack = new LinkedList<>();
        if (null == root) {
            return res;
        }
        stack.add(root);
        while (!stack.isEmpty()) {
            Node node = stack.pollLast();
            res.add(node.val);
            Collections.reverse(node.children);
            for (int i = 0; i < node.children.size(); i++) {
                stack.add(node.children.get(i));
            }
        }

        return res;
    }




    private static class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    };
}
