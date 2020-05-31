package com.algorithm.secondweek.homework;

/**
 * 丑数
 * https://leetcode-cn.com/problems/chou-shu-lcof/solution/mian-shi-ti-49-chou-shu-dong-tai-gui-hua-qing-xi-t/
 */
public class ChouShuIcof {

    public static void main(String[] args) {
        nthUglyNumber(10);

    }

    /**
     * 动态规划
     * 时间复杂度 O(N) ： 其中 N=n ，动态规划需遍历计算 dp 列表。
     * 空间复杂度 O(N) ： 长度为 NN 的 dp 列表使用 O(N) 的额外空间
     * @param n
     * @return
     */
    public static int nthUglyNumber(int n) {
        int a = 0;
        int b= 0;
        int c = 0;

        int[] dp = new int[n];
        dp[0] = 1;
        for (int i = 0; i < n; i++) {
            int n2 = dp[a]*2, n3 = dp[b]*3, n5 = dp[c]*5;
            dp[i] = Math.min(Math.min(n2, n3), n5);
            if (dp[i] == n2) {
                a++;
            }
            if (dp[i] == n3) {
                b++;
            }
            if (dp[i] == n5) {
                c++;
            }
        }

        return dp[n-1];
    }
}
