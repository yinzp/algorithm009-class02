package com.algorithm.fristweek.homework;

/**
 * 旋转数组
 */
public class RotateArray {

    private static int[] nums = {1,2,3,4,5,6,7};
    //private static int[] nums = {1,2};
    private static int k = 3;

    public static void main(String[] args) {
        rotate3(nums, k);
    }

    /**
     * 使用一个额外的数组
     * 这个接法有局限性，{1,2}, 3 无法测试通过
     * 时间复杂度 O(2n)
     * 空间复杂度 O(n)
     * @param nums
     * @param k
     */
    public static void rotate1(int[] nums, int k) {
        if (null == nums || k >= nums.length){
            return;
        }

        int[] temp = new int[nums.length];
        int j = nums.length - k;
        for (int i = 0; i < k; i++) {
            temp[i] = nums[j];
            j++;
        }
        j = 0;
        while (j < (nums.length - k)) {
            temp[j+k] = nums[j];
            j++;
        }

        System.arraycopy(temp, 0, nums, 0, nums.length);

        return;
    }

    /**
     * 每次将数组旋转 1 个元素
     * 时间复杂度：O(n*k) 。每个元素都被移动 1 步
     * 空间复杂度：O(1) 。没有额外空间被使用。
     * @param nums
     * @param k
     */
    public static void rotate2(int[] nums, int k) {
        int temp, prev;
        int len = nums.length;
        for (int i = 0; i < k; i++) {
            prev = nums[len - 1];
            for (int j = 0; j < len; j++) {
                temp = nums[j];
                nums[j] = prev;
                prev = temp;
            }
        }

    }

    public static void rotate3(int[] nums, int k) {
        int len = nums.length;
        int[] temp = new int[len];
        for (int i = 0; i < len; i++) {
            int index = (i + k) % len;
            temp[index] = nums[i];
        }
        for (int i = 0; i < len; i++) {
            nums[i] = temp[i];
        }
    }
}
