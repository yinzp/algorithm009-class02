package com.algorithm.fristweek.homework;

public class RotateArray {

    private static int[] nums = {1,2,3,4,5,6,7};
    private static int k = 3;

    public static void main(String[] args) {

    }

    public static void rotate(int[] nums, int k) {
        int j = nums.length -1;
        for (int i = 0; i < k; i++) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }


    }
}
