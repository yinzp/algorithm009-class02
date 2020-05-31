package com.algorithm.secondweek.homework;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collections;

public class StrAnagram {

    private static String s = "a";
    private static String t = "ab";

    public static void main(String[] args) {
        isAnagram2(s, t);
    }

    /**
     * 时间复杂度：O(nlogn)，假设 n 是 s 的长度，排序成本O(nlogn) 和比较两个字符串的成本 O(n)。
     *      排序时间占主导地位，总体时间复杂度为 O(nlogn)
     * 空间复杂度：O(1)，空间取决于排序实现，如果使用 heapsort，通常需要 O(1)O 辅助空间。
     *      注意，在 Java 中，toCharArray() 制作了一个字符串的拷贝，所以它花费 O(n) 额外的空间
     * @param t
     * @return
     */
    public static boolean isAnagram1(String s, String t) {
        char[] sChar = s.toCharArray();
        char[] tChar = t.toCharArray();
        Arrays.sort(sChar);
        Arrays.sort(tChar);
        return Arrays.equals(sChar, tChar);
    }

    /**
     * 时间复杂度：O(n)。时间复杂度为 O(n) 因为访问计数器表是一个固定的时间操作。
     * 空间复杂度：O(1)。尽管我们使用了额外的空间，但是空间的复杂性是 O(1)，因为无论 NN 有多大，表的大小都保持不变。
     * @param s
     * @param t
     * @return
     */
    public static boolean isAnagram2(String s, String t) {
        int[] count = new int[26];

        if (s.length() != t.length()){
            return false;
        }
        for (int i = 0; i < t.length(); i++) {
            count[s.charAt(i) - 'a']++;
            count[t.charAt(i) - 'a']--;
        }
        for (int i = 0; i < count.length; i++) {
            if (count[i] != 0) {
                return false;
            }
        }

        return true;
    }

    /**
     * 先用计数器表计算 ss，然后用 tt 减少计数器表中的每个字母的计数器。
     * 如果在任何时候计数器低于零，我们知道 t 包含一个不在 s 中的额外字母，并立即返回 FALSE
     * @param s
     * @param t
     * @return
     */
    public static boolean isAnagram3(String s, String t) {
        int[] count = new int[26];
        if (t.length() != t.length()) {
            return false;
        }
        for (int i = 0; i < t.length(); i++) {
            count[t.charAt(i) - 'a']++;
        }
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']--;
            if (count[s.charAt(i) - 'a'] < 0) {
                return false;
            }
        }
        return true;
    }


}
