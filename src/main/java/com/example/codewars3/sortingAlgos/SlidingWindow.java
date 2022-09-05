package com.example.codewars3.sortingAlgos;

public class SlidingWindow {

    public static void main(String[] args) {
        System.out.println(maxSumSize(new int[]{4, 2, 1, 7, 8, 1, 2, 8, 1, 0}, 3));
        System.out.println(smallestSubarray(6, new int[]{4, 2, 1, 7, 8, 1, 2, 8, 1, 0}));
    }

    public static int smallestSubarray(int targetSum, int[] arr) {
        int minWindowSize = Integer.MAX_VALUE;
        int currentWindowSum = 0;
        int windowStart = 0;
        for (int windowEnd = 0; windowEnd < arr.length; windowEnd++) {
            currentWindowSum += arr[windowEnd];

            while (currentWindowSum >= targetSum) {
                minWindowSize = Math.min(minWindowSize, windowEnd - windowStart + 1);
                currentWindowSum -= arr[windowStart];
                windowStart++;
            }
        }

        return minWindowSize;
    }
    //used for everything grouped sequentially
    //longest/smallest/constants/max/min
    //Fixed Lenght
    //Dynamic Variant

    //using sliding window technigue
    public static int maxSumSize(int[] arr, int size) {
        int max = Integer.MIN_VALUE;
        int currentRunningSum = 0;
        for (int i = 0; i < arr.length; i++) {
            currentRunningSum += arr[i];
            if (i >= size - 1) {
                max = Math.max(max, currentRunningSum);
                currentRunningSum -= arr[i - (size - 1)];
            }
        }
        return max;
    }
}
