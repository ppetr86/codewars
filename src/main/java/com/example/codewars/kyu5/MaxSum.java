package com.example.codewars.kyu5;
//https://www.codewars.com/kata/52f4261c95d6bff39a003096/train/java
//https://www.codewars.com/kata/52f4261c95d6bff39a003096/solutions/java

public class MaxSum {
    public static void main(String[] args) {
        System.out.println(maxContiguousSum(new int[]{2, -3, -3, 9, -1, -1, 9}));
    }

    public static int maxContiguousSum(final int[] arr) {
        int max = Integer.MIN_VALUE;
        int holder = 0;

        for (int i = 0; i < arr.length; i++) {
            holder = holder + arr[i];
            if (max < holder) max = holder;
            if (holder < 0) holder = 0;
        }
        return Math.max(max, 0);
    }

  /*public static int maxContiguousSum(final int[] arr) {
    int result = arr[0];
    System.out.println(MyArrays.toString(arr));

    for (int i = 0; i < arr.length - 1; i++) {
      int dummy = arr[i];
      for (int j = i; j < arr.length; j++) {
        if (i == j) result = Math.max(result, arr[i]);
        else {
          dummy += arr[j];
          result = Math.max(result, dummy);
        }
      }
    }
    return result;
  }*/

    public static void sort(int arrayToSort[]) {
        int n = arrayToSort.length;

        for (int gap = n / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < n; i++) {
                int key = arrayToSort[i];
                int j = i;
                while (j >= gap && arrayToSort[j - gap] > key) {
                    arrayToSort[j] = arrayToSort[j - gap];
                    j -= gap;
                }
                arrayToSort[j] = key;
            }
        }
    }

  /*public static int maxContiguousSum(final int[] arr) {
    int max = 0, sum = 0;
    for (int num : arr)
    {
      sum = Math.max(sum + num, 0);
      max = Math.max(sum, max);
    }
    return max;
  }*/
}
