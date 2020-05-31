package com.algorithm.secondweek.homework;
import java.util.*;

import java.util.List;

/**
 * N叉树的层序遍历
 * https://leetcode-cn.com/problems/n-ary-tree-level-order-traversal/
 */
public class NAryTreeLevelOrderTraversal {

    public static void main(String[] args) {

    }

    /**
     * 利用队列实现广度优先搜索
     * 时间复杂度：O(n)。n 指的是节点的数量。
     * 空间复杂度：O(n)。
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> mList = new ArrayList<List<Integer> > ();
        if (null == root) {
            return mList;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            List<Integer> level = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node node = queue.poll();
                level.add(node.val);
                queue.addAll(node.children);
            }
            mList.add(level);
        }
        return mList;
    }

    private class Node {
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
    }
}
