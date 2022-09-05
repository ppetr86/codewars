package com.example.codewars3.hackerRank;

import java.util.Arrays;

public class MaxMin {

    public static void main(String[] args) {
        System.out.println(maxMin(3, new int[]{100, 200, 300, 350, 400, 401, 402}));
    }

    static int maxMin(int k, int[] arr) {
        Arrays.sort(arr);
        int result = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length - k + 1; i++) {
            int max = arr[i + k - 1];
            int min = arr[i];
            int holder = max - min;
            if (holder < result) result = holder;
        }
        return result;
    }
}
