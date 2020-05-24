package com.algorithm.fristweek.homework;

import java.awt.*;

public class PlusOne {

    private static int[] nums = {9};

    public static void main(String[] args) {
        plusOne2(nums);
    }

    /**
     * 时间复杂度 O(n)
     * 空间复杂度 O(n)
     * @param digits
     * @return
     */
    public static int[] plusOne1(int[] digits) {
        int len = digits.length;
        int i = len - 1;
        int[] temp = null;

        if (digits[len - 1] < 9){
            digits[len - 1] += 1;
            return digits;
        }
        while (i >= 0) {
            if (i > 0) {
                if (digits[i] >= 9) {
                    digits[i] = 0;
                    digits[i-1] += 1;
                    if (digits[i-1] > 9){
                        i--;
                    } else {
                        break;
                    }
                } else {
                    break;
                }
            } else {
                temp = new int[len + 1];
                digits[i] = 0;
                temp[0] = 1;
                //System.arraycopy(digits, 0, temp, 1, len);
                break;
            }

        }

        return null == temp ? digits : temp;
    }

    /**
     * 时间复杂度 O(n)
     * 空间复杂度 O(n)
     * @param digits
     * @return
     */
    public static int[] plusOne2(int[] digits) {
        int len = digits.length;
        for (int i = len -1; i >= 0 ; i--) {
            digits[i]++;
            digits[i] %= 10;
            if (digits[i] != 0) {
                return digits;
            }
        }

        int[] temp = new int[len + 1];
        temp[0] = 1;
        return temp;
    }
}