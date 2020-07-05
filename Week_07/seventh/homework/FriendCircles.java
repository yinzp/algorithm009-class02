package com.algorithm.seventh.homework;

import java.util.Arrays;

public class FriendCircles {

    private static int[][] nums =  {
            {1,1,0},
            {1,1,0},
            {0,0,1}
    };


    public static void main(String[] args) {
        findCircleNum(nums);
        findCircleNum1(nums);
        findCircleNum2(nums);
    }

    /******************************深度优先搜索********************************/
    /**
     * 深度优先搜索
     * 时间复杂度：O(n^2)，整个矩阵都要被遍历，大小为 n^2
     * 空间复杂度：O(n)，visited 数组的大小。
     * @param M
     * @return
     */
    public static int findCircleNum(int[][] M) {
        int[] visited = new int[M.length];
        int count = 0;
        for (int i = 0; i < M.length; i++) {
            if (visited[i] == 0) {
                dfs(M, visited, i);
                count++;
            }
        }
        return count;
    }

    private static void dfs(int[][] M, int[] visited, int i) {
        for (int j = 0; j < M.length; j++) {
            if (M[i][j] == 1 && visited[j] == 0) {
                visited[j] = 1;
                dfs(M, visited, j);
            }
        }
    }

    /*********************************广度优先搜索*******************************/

    /**
     * 广度优先搜索
     * 时间复杂度：O(n^2)，整个矩阵都要被访问。
     * 空间复杂度：O(n)，queue 和 visited 数组的大小。

     * @param M
     * @return
     */
    public static int findCircleNum1(int[][] M) {
        int[] visited = new int[M.length];
        int count = 0;
        for (int i = 0; i < M.length; i++) {
            if (visited[i] == 0) {
                bfs(M, visited, i);
                count++;
            }
        }
        return count;
    }

    private static void bfs(int[][] M, int[] visited, int i) {
        for (int j = 0; j < M.length; j++) {
            if (M[i][j] == 1 && visited[j] == 0) {
                visited[j] = 1;
                bfs(M, visited, j);
            }
        }
    }

    /*********************************并查集****************************************/


    private static int find(int parent[], int i) {
        if (parent[i] == -1)
            return i;
        return find(parent, parent[i]);
    }

    private static void  union(int parent[], int x, int y) {
        int xset = find(parent, x);
        int yset = find(parent, y);
        if (xset != yset)
            parent[xset] = yset;
    }

    /**
     * 时间复杂度：O(n^3)，访问整个矩阵一次，并查集操作需要最坏 O(n)O(n) 的时间。
     * 空间复杂度：O(n)，parent 大小为 n。
     * @param M
     * @return
     */
    public static int findCircleNum2(int[][] M) {
        int[] parent = new int[M.length];
        Arrays.fill(parent, -1);
        for (int i = 0; i < M.length; i++) {
            for (int j = 0; j < M.length; j++) {
                if (M[i][j] == 1 && i != j) {
                    union(parent, i, j);
                }
            }
        }
        int count = 0;
        for (int i = 0; i < parent.length; i++) {
            if (parent[i] == -1)
                count++;
        }
        return count;
    }

}
