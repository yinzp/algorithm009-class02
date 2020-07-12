package com.algorithm.eighthweek.homework;

public class NumberOfOneBits {

    private static final int num = 00000000000000000000000000001011;
    public static void main(String[] args) {
        int n = hammingWeight(num);
        int m = hammingWeight1(num);
    }

    /**
     * 时间复杂度：O(1) 。运行时间依赖于数字 n 的位数。由于这题中 n 是一个 32 位数，所以运行时间是 O(1) 的。
     * 空间复杂度：O(1)。没有使用额外空间
     *
     * @param n
     * @return
     */
    public static int hammingWeight(int n) {
        int bits = 0;
        int mask = 1;
        for (int i = 0; i < 32; i++) {
            if ((n & mask) != 0) {
                bits++;
            }
            mask <<= 1;
        }
        return bits;
    }

    /**
     * 时间复杂度：O(1) 。运行时间与 n 中位为 1 的有关。在最坏情况下， n 中所有位都是 1 。对于 32 位整数，运行时间是 O(1) 的。
     * 空间复杂度：O(1) 。没有使用额外空间。
     * @param n
     * @return
     */
    public static int hammingWeight1(int n) {
        int sum = 0;
        while (n != 0) {
            sum++;
            n &= (n - 1);
        }
        return sum;
    }
}
