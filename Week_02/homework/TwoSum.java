package com.algorithm.secondweek.homework;

import java.lang.annotation.Target;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    private static int[] nums = {3, 2, 4};
    private static int target = 6;

    public static void main(String[] args) {
        twoSum2(nums, target);
    }

    /**
     * 一遍哈希表
     * 时间复杂度：O(n)，
     * 空间复杂度：O(n)，
     * @param target
     * @return
     */
    private static int[] twoSum1(int[] nums, int target){
        int[] result = new int[2];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int key = target - nums[i];
            if (map.containsKey(key)) {
                result[0] = i;
                result[1] = map.get(key);
                break;
            }
            map.put(nums[i], i);
        }

        return result;
    }

    /**
     * 两遍hash
     * 时间复杂度：O(n)，
     * 空间复杂度：O(n)，
     * @param nums
     * @param target
     * @return
     */
    private static int[] twoSum2(int[] nums, int target){
        int[] result = new int[2];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            int key = target - nums[i];
            if (map.containsKey(key) && map.get(key) != i) {
                result[0] = map.get(key);
                result[1] = i;
                return result;
            }
        }

        return null;
    }
}
