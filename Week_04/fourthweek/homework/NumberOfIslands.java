package com.algorithm.fourthweek.homework;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。
 * 岛屿总是被水包围，并且每座岛屿只能由水平方向或竖直方向上相邻的陆地连接形成。
 * 此外，你可以假设该网格的四条边均被水包围。
 *
 * https://leetcode-cn.com/problems/number-of-islands/
 */
public class NumberOfIslands {

    private static char[][] grid = {
            {1,1,1,1,0},
            {1,1,0,1,0},
            {1,1,0,0,0},
            {0,0,0,0,0}
    };

    private static int m = 0;
    private static int n = 0;

    private static int nr = 0;
    private static int nc = 0;

    public static void main(String[] args) {
        numIslands1(grid);
    }

    /**
     * 深度优先搜索
     *
     * 时间复杂度：O(MN)，其中 MM 和 NN 分别为行数和列数。
     * 空间复杂度：O(MN)，在最坏情况下，整个网格均为陆地，深度优先搜索的深度达到 MN。
     *
     * @param grid
     * @return
     */
    public static int numIslands1(char[][] grid) {
        int count = 0;
        n = grid.length;
        if (n <= 0) {
            return 0;
        }

        m = grid[0].length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    ++count;
                    dfsMarking(grid, i, j);
                }
            }
        }

        return count;
    }


    private static void dfsMarking(char[][] grid, int i, int j){
        if (i < 0 || j < 0 || i >= n || j >= m || grid[i][j] !=  1) {
            return;
        }

        grid[i][j] = 0;
        dfsMarking(grid, i+1, j);
        dfsMarking(grid, i-1, j);
        dfsMarking(grid, i, j+1);
        dfsMarking(grid, i, j-1);
    }


    /**
     * 广度优先搜索
     *
     * 时间复杂度：O(MN)，其中 M 和 N 分别为行数和列数。
     * 空间复杂度：O(min(M,N))，在最坏情况下，整个网格均为陆地，队列的大小可以达到 min(M,N)
     *
     * @param grid
     * @return
     */
    public static int numIslands2(char[][] grid) {
        int count = 0;
        nr = grid.length;
        if (nr <= 0) {
            return 0;
        }
        nc = grid[0].length;

        for (int r = 0; r < nr; r++) {
            for (int c = 0; c < nc; c++) {
                if (grid[r][c] == 1) {
                    ++count;
                    grid[r][c] = '0';
                    Queue<Integer> neighbors = new LinkedList<>();
                    neighbors.add(r*nc+c);
                    while (!neighbors.isEmpty()) {
                        int id = neighbors.remove();
                        int row = id / nc;
                        int col = id % nc;
                        if (row - 1 >= 0 && grid[row -1][col] == '1') {
                            neighbors.add((row - 1) * nc + col);
                            grid[row - 1][col] = '0';
                        }
                        if (row + 1 < nr && grid[row + 1][col] == '1') {
                            neighbors.add((row + 1) * nc + col);
                            grid[row + 1][col] = '0';
                        }
                        if (col - 1 >= 0 && grid[row][col - 1] == '1') {
                            neighbors.add(row * nc + (col - 1));
                            grid[row][col - 1] = '0';
                        }

                        if (col + 1 < nc && grid[row][col + 1] == '1') {
                            neighbors.add(row * nc + (col + 1));
                            grid[row][col + 1] = '0';
                        }
                    }
                }
            }
        }


        return count;
    }
}
