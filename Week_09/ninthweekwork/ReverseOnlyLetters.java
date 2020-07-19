package com.algorithm.ninthweekwork;

import java.util.Stack;

public class ReverseOnlyLetters {

    private static final String str = "ab-cd";

    public static void main(String[] args) {
        reverseOnlyLetters(str);
        reverseOnlyLetters2(str);
    }

    /**
     * 时间复杂度：O(N)，其中 N 是 S 的长度。
     * 空间复杂度：O(N)。
     * @param S
     * @return
     */
    public static String reverseOnlyLetters(String S) {
        Stack<Character> letters = new Stack();
        for (char c: S.toCharArray())
            if (Character.isLetter(c))
                letters.push(c);

        StringBuilder ans = new StringBuilder();
        for (char c: S.toCharArray()) {
            if (Character.isLetter(c))
                ans.append(letters.pop());
            else
                ans.append(c);
        }

        return ans.toString();
    }

    /**
     * 反转指针
     * 时间复杂度：O(N)，其中 N 是 S 的长度。
     * 空间复杂度：O(N)。
     * @param S
     * @return
     */
    public static String reverseOnlyLetters2(String S) {
        StringBuilder ans = new StringBuilder();
        int j = S.length() - 1;
        for (int i = 0; i < S.length(); ++i) {
            if (Character.isLetter(S.charAt(i))) {
                while (!Character.isLetter(S.charAt(j)))
                    j--;
                ans.append(S.charAt(j--));
            } else {
                ans.append(S.charAt(i));
            }
        }

        return ans.toString();
    }


}
