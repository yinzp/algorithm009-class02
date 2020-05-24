package com.algorithm.fristweek.homework;
import com.sun.org.apache.regexp.internal.RE;

import java.lang.reflect.Array;
import java.util.*;

/**
 * 两数之和
 */
public class TwoSum {

   /* private static int[] nums = {81, 100, 2, 11, 7,15, 5, -3};
    private static int target = 9;*/

    private static int[] nums = {3, 3};
    private static int target = 6;

    public static void main(String[] args) {
        twoSum3(nums, target);
    }

    /**
     * 暴力求解
     * 时间复杂度O(n^2)
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSum1(int[] nums, int target) {
        if (null == nums || nums.length < 2) {
            return null;
        }
        int[] result = new int[2];
        int len = nums.length;
        boolean hasFind = false;
        for (int i = 0; i < len -1; i++){
            for (int j = i+1; j < len; j++) {
                if (target == nums[i] + nums[j]){
                    hasFind = true;
                    result[0] = i;
                    result[1] = j;
                    break;
                }
            }
            if (hasFind){
                break;
            }
        }
        return result;
    }

    /**
     * 双指针法
     * 夹逼原理
     * 时间复杂度O(n)
     * 空间复杂度：O(n)
     * 这种做法有漏洞，数组中存在重复元素，可能会出现问题， 如[3, 3] 6
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSum2(int[] nums, int target) {
        if (null == nums || nums.length < 2) {
            return null;
        }
        int[] result = new int[2];
        Map<Integer, Integer> numsMap = new HashMap<Integer, Integer>();
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            numsMap.put(nums[i], i);
        }
        Arrays.sort(nums);
        int L = 0;
        int R = len -1;
        while (L < R) {
            int sum = nums[L] + nums[R];
            System.out.println("sum = " + sum);
            if (sum < target) {
                L++;
            } else if (sum > target) {
                R--;
            } else {
                result[0] = numsMap.get(nums[L]);
                result[1] = numsMap.get(nums[R]);
                break;
            }
        }

        return result;
    }

    /**
     * 先put进去的值被更新了，如果答案是两个重复的数相加，由于只有唯一答案，
     * 数组从头遍历的话，会先遇到被覆盖更新的第一个数字，
     * 那么从map中判断取出后面更新的数，那么返回的结果是不会错的。
     * 如果答案不是两个重复的数相加，那么那个重复的数丢掉也无所谓的
     *
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSum3(int[] nums, int target) {
        if (null == nums || nums.length < 2) {
            return null;
        }
        int[] result = new int[2];
        Map<Integer, Integer> numsMap = new HashMap<Integer, Integer>();
        int len = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < len; i++) {
            map.put(nums[i], i);
        }
        for (int i = 0; i < len; i++) {
            int key = target - nums[i];
            if (map.containsKey(key) && map.get(key) != i) {
                result[0] = i;
                result[1] = map.get(key);
                break;
            }
        }
        return result;
    }

    /**
     * 一遍hash
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSum4(int[] nums, int target) {
        if (null == nums || nums.length < 2) {
            return null;
        }
        int[] result = new int[2];
        Map<Integer, Integer> numsMap = new HashMap<Integer, Integer>();
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            int key = target - nums[i];
            if (numsMap.containsKey(key)) {
                result[0] = numsMap.get(key);
                result[1] = i;
                break;
            }
            numsMap.put(nums[i], i);
        }

        return result;

    }
}
