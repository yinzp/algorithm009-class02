package com.algorithm.secondweek.homework;
import	java.util.ArrayList;

import java.util.*;

/**
 * 字母异位词分组
 * https://leetcode-cn.com/problems/group-anagrams/
 */
public class GroupAnagrams {

    private static String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};

    public static void main(String[] args) {
        groupAnagrams2(strs);
    }

    /**
     * 时间复杂度：O(NKlogK)，其中 N 是 strs 的长度，而 K 是 strs 中字符串的最大长度。
     * 当遍历每个字符串时，外部循环具有的复杂度为 O(N)。然后，我们在 O(KlogK) 的时间内对每个字符串排序。*
     * 空间复杂度：O(NK)，排序存储在 ans 中的全部信息内容
     * @param strs
     * @return
     */
    public static List<List<String>> groupAnagrams1(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            char[] sChar = strs[i].toCharArray();
            Arrays.sort(sChar);
            String key = String.valueOf(sChar);
            if (map.containsKey(key)) {
                map.get(key).add(strs[i]);
            } else {
                map.put(key, new ArrayList<String>());
            }
        }
        List<List<String>> mList = new ArrayList<> ();
        mList.addAll(map.values());
        return mList;
    }

    public static List<List<String>> groupAnagrams2(String[] strs) {
        List<List<String>> mList = new ArrayList<> ();
        if (strs.length == 0) {
            return mList;
        }
        Map<String, List<String>> map = new HashMap<>();

        int[] count = new int[26];

        for (int i = 0; i < strs.length; i++) {
            Arrays.fill(count, 0);
            char[] c = strs[i].toCharArray();
            for (int j = 0; j < c.length; j++) {
                count[c[j] - 'a']++;
            }

            StringBuilder sb = new StringBuilder("");
            for (int k = 0; k < 26; k++) {
                sb.append('#');
                sb.append(count[k]);
            }
            String key = sb.toString();
            if (map.containsKey(key)) {
                map.get(key).add(strs[i]);
            } else {
                map.put(key, new ArrayList<String>());
            }
        }

        mList.addAll(map.values());
        return mList;

    }


    private static boolean isAnagram(String s, String d, int[] count) {
        if (s.length() != d.length()) {
            return false;
        }
        Arrays.fill(count, 0);
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < d.length(); i++) {
            count[d.charAt(i) - 'a']--;
            if (count[d.charAt(i) - 'a'] < 0) {
                return false;
            }
        }

        return true;
    }

}
