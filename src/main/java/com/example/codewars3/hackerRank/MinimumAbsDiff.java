package com.example.codewars3.hackerRank;

import java.util.Arrays;

public class MinimumAbsDiff {

    public static void main(String[] args) {
        System.out.println(minimumAbsoluteDifference(new int[]{1, -3, 71, 68, 17}));
    }

    static int minimumAbsoluteDifference(int[] arr) {
        int result = Integer.MAX_VALUE;
        Arrays.sort(arr);
        for (int i = 0; i < arr.length - 1; i++) {
            int diff = Math.abs(arr[i] - arr[i + 1]);
            if (diff < result) result = diff;
        }
        return result;
    }
}
