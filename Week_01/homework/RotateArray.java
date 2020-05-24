package com.algorithm.fristweek.homework;

/**
 * ��ת����
 */
public class RotateArray {

    private static int[] nums = {1,2,3,4,5,6,7};
    //private static int[] nums = {1,2};
    private static int k = 3;

    public static void main(String[] args) {
        rotate3(nums, k);
    }

    /**
     * ʹ��һ�����������
     * ����ӷ��о����ԣ�{1,2}, 3 �޷�����ͨ��
     * ʱ�临�Ӷ� O(2n)
     * �ռ临�Ӷ� O(n)
     * @param nums
     * @param k
     */
    public static void rotate1(int[] nums, int k) {
        if (null == nums || k >= nums.length){
            return;
        }

        int[] temp = new int[nums.length];
        int j = nums.length - k;
        for (int i = 0; i < k; i++) {
            temp[i] = nums[j];
            j++;
        }
        j = 0;
        while (j < (nums.length - k)) {
            temp[j+k] = nums[j];
            j++;
        }

        System.arraycopy(temp, 0, nums, 0, nums.length);

        return;
    }

    /**
     * ÿ�ν�������ת 1 ��Ԫ��
     * ʱ�临�Ӷȣ�O(n*k) ��ÿ��Ԫ�ض����ƶ� 1 ��
     * �ռ临�Ӷȣ�O(1) ��û�ж���ռ䱻ʹ�á�
     * @param nums
     * @param k
     */
    public static void rotate2(int[] nums, int k) {
        int temp, prev;
        int len = nums.length;
        for (int i = 0; i < k; i++) {
            prev = nums[len - 1];
            for (int j = 0; j < len; j++) {
                temp = nums[j];
                nums[j] = prev;
                prev = temp;
            }
        }

    }

    public static void rotate3(int[] nums, int k) {
        int len = nums.length;
        int[] temp = new int[len];
        for (int i = 0; i < len; i++) {
            int index = (i + k) % len;
            temp[index] = nums[i];
        }
        for (int i = 0; i < len; i++) {
            nums[i] = temp[i];
        }
    }
}
