package com.example.hackerRank;

import java.util.Arrays;

public class LargestRectangle {

    public static void main(String[] args) {
        System.out.println(largestRectangle(new int[]{1, 2, 3, 4, 5}));
    }

    static long largestRectangle(int[] h) {
        long result = 0L;
        for (int i = 0; i < h.length - 1; i++) {
            for (int j = i; j < h.length; j++) {
                result = Math.max(result, areaOfArr(Arrays.copyOfRange(h, i, j + 1)));
            }
        }
        return result;
    }

    private static long areaOfArr(int[] h) {
        return (long) Arrays.stream(h).min().orElse(0) * h.length;
    }

}
