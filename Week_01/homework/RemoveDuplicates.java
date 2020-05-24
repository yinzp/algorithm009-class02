package com.algorithm.fristweek.homework;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 删除排序数组中的重复项
 */
public class RemoveDuplicates {

    private static int[] nums1 = {0,0,1,1,1,2,2,3,3,4};
    private static int[] nums2 = {1,1,2};

    public static void main(String[] args) {
        removeDuplicates2(nums1);
    }

    /**
     * 一遍hash
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     * @param nums
     * @return
     */
    public static int removeDuplicates1(int[] nums) {
        if (null == nums) {
            return 0;
        }
        Map<Integer, Integer> numsMap = new HashMap<>();
        int len = nums.length;
        int j = 0;
        for (int i = 0; i < len; i++) {
            if (!numsMap.containsKey(nums[i])) {
                nums[j] = nums[i];
                j++;
            }
            numsMap.put(nums[i], i);
        }

        return j;
    }

    /**
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     * @param nums
     * @return
     */
    public static int removeDuplicates2(int[] nums) {
        int j = 0;
        if (null == nums) {
            return 0;
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != nums[j]) {
                j++;
                nums[j] = nums[i];

            }
        }

        return j+1;
    }
}
