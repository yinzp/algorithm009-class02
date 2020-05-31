package com.algorithm.secondweek.homework;
import java.lang.reflect.Array;
import java.util.*;

/**
 * 前 K 个高频元素
 * https://leetcode-cn.com/problems/top-k-frequent-elements/
 */
public class TopKFrequentElements {

    private static int[]  nums = {1,1,1,2,2,3};
    private static int k = 2;

    public static void main(String[] args) {

        topKFrequent(nums, k);

    }

    public static int[] topKFrequent(int[] nums, int k) {
        if (null == nums) {
            return null;
        }

        // 使用字典，统计每个元素出现的次数，元素为键，元素出现的次数为值
        final Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                map.put(nums[i], map.get(nums[i]) + 1);
            }else {
                map.put(nums[i], 1);
            }
        }

        // 遍历map，用最小堆保存频率最大的k个元素
        PriorityQueue<Integer> pq = new PriorityQueue<>(nums.length, new Comparator<Integer> () {

            @Override
            public int compare(Integer o1, Integer o2) {
                return map.get(o1) - map.get(o2);
            }
        });

        for (Integer key : map.keySet()) {
            if (pq.size() < k) {
                pq.add(key);
            } else if (map.get(key) > map.get(pq.peek())){
                pq.remove();
                pq.add(key);
            }

        }
        if (pq.isEmpty()) {
            return null;
        }
        int[] res = new int[pq.size()];
        int i = 0;

        while (!pq.isEmpty()) {
            res[i] = pq.remove();// 取出最小堆中的元素 添加到数组中
            i++;
        }
        return res;

    }

}
