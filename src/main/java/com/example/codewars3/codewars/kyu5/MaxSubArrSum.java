package com.example.codewars3.codewars.kyu5;

import java.util.Arrays;

public class MaxSubArrSum {
    public static void main(String[] args) {
        System.out.println(sequence(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 55}));
    }

    public static int sequence(int[] arr) {
        int countPositive = (int) Arrays.stream(arr).filter(x -> x > -1).count();
        if (arr.length == 0 || countPositive == 0) return 0;
        int maxSoFar = arr[0];

        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                int holder = Arrays.stream(Arrays.copyOfRange(arr, i, j + 1)).sum();
                maxSoFar = Math.max(holder, maxSoFar);
            }
        }
        return maxSoFar;
    }
  /*public static int sequence(int[] arr) {
    int max_ending_here = 0, max_so_far = 0;
    for (int v : arr) {
      max_ending_here = Math.max(0, max_ending_here + v);
      max_so_far = Math.max(max_so_far, max_ending_here);
    }
    return max_so_far;
  }*/

}
