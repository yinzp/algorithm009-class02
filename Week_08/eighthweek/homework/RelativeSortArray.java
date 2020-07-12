package com.algorithm.eighthweek.homework;

public class RelativeSortArray {

    private static int[] arr1 = {2,3,1,3,2,4,6,7,9,2,19};
    private static int[] arr2 = {2,1,4,3,9,6};

    public static void main(String[] args) {
        relativeSortArray(arr1, arr2);
    }

    public static int[] relativeSortArray(int[] arr1, int[] arr2) {
        int[] m = new int[1001];
        int[] ref = new int[arr1.length];

        for(int i = 0; i < arr1.length; i++) {
            m[arr1[i]]++;
        }

        int cnt = 0;
        for(int i = 0; i < arr2.length; i++) {
            while(m[arr2[i]] > 0) {
                ref[cnt++] = arr2[i];
                m[arr2[i]]--;
            }
        }

        for(int i = 0; i < 1001; i++) {
            while(m[i] > 0) {
                ref[cnt++] = i;
                m[i]--;
            }
        }
        return ref;
    }
}
