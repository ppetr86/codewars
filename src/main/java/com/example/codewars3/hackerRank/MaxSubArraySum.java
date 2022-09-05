package com.example.codewars3.hackerRank;

import java.util.Arrays;

public class MaxSubArraySum {
    public static void main(String[] args) {
        System.out.println(maximumSum(new long[]{1, 5, 9, 6}, 5));
    }

    static long maximumSum(long[] a, long m) {

        long result = 0;
        for (int i = 0; i < a.length; i++) {
            for (int j = i; j < a.length; j++) {
                long[] copy = Arrays.copyOfRange(a, i, j + 1);
                System.out.println(Arrays.toString(copy));
                long holder = Arrays.stream(copy).sum() % m;
                if (holder > result) result = holder;
            }
        }

        return result;
    }
}
