package com.algorithm.fourthweek.homework;

/**
 * 买卖股票的最佳时机 II
 * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii/solution/tan-xin-suan-fa-by-liweiwei1419-2/
 */
public class BestTimeToBuyAndSellStock {

    private static int[] prices = {7,1,5,3,6,4};

    public static void main(String[] args) {
        //maxProfit1(prices);
        maxProfit2(prices);

    }

    /**
     *时间复杂度：O(n)，遍历一次。
     * 空间复杂度：O(1)，需要常量的空间。
     */
    public static int maxProfit1(int[] prices) {
        int maxprofit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1])
                maxprofit += prices[i] - prices[i - 1];
        }
        return maxprofit;
    }
    /**
     * 时间复杂度：O(N)，这里 NN 表示股价数组的长度。
     * 空间复杂度：O(1)，分别使用两个滚动变量，将一维数组状态压缩到常数。
     * @param prices
     * @return
     */
    public static int maxProfit2(int[] prices) {
        int len = prices.length;
        if (len < 2) {
            return 0;
        }

        // cash：持有现金
        // hold：持有股票
        // 状态转移：cash → hold → cash → hold → cash → hold → cash

        int cash = 0;
        int hold = -prices[0];

        int preCash = cash;
        int preHold = hold;
        for (int i = 1; i < len; i++) {
            cash = Math.max(preCash, preHold + prices[i]);
            hold = Math.max(preHold, preCash - prices[i]);

            preCash = cash;
            preHold = hold;
        }

        return cash;
    }
}
