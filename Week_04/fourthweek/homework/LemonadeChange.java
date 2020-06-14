package com.algorithm.fourthweek.homework;

/**
 *
 * https://leetcode-cn.com/problems/lemonade-change/description/
 *
 * 在柠檬水摊上，每一杯柠檬水的售价为 5 美元。
 * 顾客排队购买你的产品，（按账单 bills 支付的顺序）一次购买一杯。
 * 每位顾客只买一杯柠檬水，然后向你付 5 美元、10 美元或 20 美元。你必须给每个顾客正确找零，也就是说净交易是每位顾客向你支付 5 美元。
 * 注意，一开始你手头没有任何零钱。
 * 如果你能给每位顾客正确找零，返回 true ，否则返回 false 。
 */
public class LemonadeChange {

    //private static int[] bills = {5,5,5,10,30};
    private static int[] bills = {5,5,10,10,20};

    public static void main(String[] args) {
        lemonadeChange(bills);
    }

    /**
     * 错误的
     * @param bills
     * @return
     */
    public static boolean lemonadeChange(int[] bills) {
        boolean ret = false;
        int money = 0;
        if (bills == null) {
            return false;
        }

        int i = 0;
        while (i < bills.length) {
            if (bills[i] % 5 != 0 || money < bills[i] - 5) {
                return false;
            }
            money += bills[i];
            money -=  bills[i] - 5;
            i++;
        }

        return true;
    }

    /**
     * 时间复杂度：O(N)，其中 N 是 bills 的长度。
     * 空间复杂度：O(1)。
     * @param bills
     * @return
     */
    public static boolean lemonadeChange1(int[] bills) {
        int five = 0;
        int ten = 0;
        if (null == bills) {
            return false;
        }
        int i = 0;
        while (i < bills.length) {
            if (bills[i] == 5) {
                five++;
            } else if (bills[i] == 10) {
                if (five == 0) {
                    return false;
                }
                five--;
                ten++;
            } else {//20
                if (five > 0 && ten > 0) {
                    five--;
                    ten--;
                } else if (five >= 3){
                    five -= 3;
                } else {
                    return false;
                }
            }
        }

        return true;
    }


}
