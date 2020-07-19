package com.algorithm.ninthweekwork;

import java.util.HashMap;
import java.util.Map;

public class FirstCharacter {

    private static final String str = "loveleetcode";

    public static void main(String[] args) {
        firstUniqChar(str);
    }

    /**
     * 时间复杂度： O(N)
     * 只遍历了两遍字符串，同时散列表中查找操作是常数时间复杂度的。
     * 空间复杂度： O(N)
     * 用到了散列表来存储字符串中每个元素出现的次数
     * @param s
     * @return
     */
    public static int firstUniqChar(String s) {
        Map<Character, Integer> count = new HashMap<Character, Integer>();
        int n = s.length();
        // build hash map : character and how often it appears
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            count.put(c, count.getOrDefault(c, 0) + 1);
        }

        // find the index
        for (int i = 0; i < n; i++) {
            if (count.get(s.charAt(i)) == 1)
                return i;
        }
        return -1;
    }
}
