package com.algorithm.eighthweek.homework;


public class PowerOfTwo {
    private static int n = 5;
    private static int m = 16;

    public static void main(String[]args){
        boolean isPower =  isPowerOfTwo(n);
        isPower =  isPowerOfTwo1(n);
        isPower =  isPowerOfTwo(m);
        isPower =  isPowerOfTwo1(m);
    }


    /**
     * 时间复杂度：O(1)
     * 空间复杂度：O(1)
     * @param n
     * @return
     */
    public static boolean isPowerOfTwo(int n) {
        if (n == 0) {
            return false;
        }
        while (n % 2 == 0) {
            n /= 2;
        }
        return n == 1;
    }

    /**
     * 时间复杂度：O(1)
     * 空间复杂度：O(1)
     * @param n
     * @return
     */
    public static boolean isPowerOfTwo1(int n) {
        if (n == 0) {
            return false;
        }
        long x = (long) n;
        return (x & (x - 1)) == 0;
    }

}
