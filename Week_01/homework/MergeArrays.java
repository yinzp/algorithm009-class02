package com.algorithm.fristweek.homework;

import java.util.Arrays;

/**
 * 合并两个有序数组
 */
public class MergeArrays {

    private static int[] nums1 = {1,2,3,0,0,0};
    private static int m = 3;

    private static int[] nums2 = {2,5,6};
    private static int n = 3;

    public static void main(String[] args) {
        merge2(nums1, m, nums2, n);
    }

    /**
     * 合并后排序
     * 时间复杂度：0(n)
     * 空间复杂度：O(1)
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public static void merge1(int[] nums1, int m, int[] nums2, int n) {
        int len1 = nums1.length;
        int j = 0;
        for (int i = m; i < len1; i++) {
            nums1[i] = nums2[j];
            j++;
        }

        Arrays.sort(nums1);
        return;
    }

    /**
     * 利用已经有的api实现
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public static void merge2(int[] nums1, int m, int[] nums2, int n) {
        System.arraycopy(nums2, 0, nums1, m, n);

        Arrays.sort(nums1);
        return;
    }
}
