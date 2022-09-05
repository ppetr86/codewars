package com.example.codewars3.hackerRank;

import java.util.Arrays;

public class MinimumSwaps {

    public static void main(String[] args) {
        System.out.println(minimumSwaps(new int[]{4, 3, 1, 2}));
    }

    static int minimumSwaps(int[] arr) {
        int result = 0;

        int lastElementInCorrectPosition = -1;
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] == i + 1) {
                lastElementInCorrectPosition = i;
                continue;
            }
            // simple switch current with next
            if (arr[i] == i + 2 && arr[i + 1] == i + 1) {
                swapArrElements(arr, i, i + 1);
                result++;
                continue;
            }
            // order is not correct && one to the right belongs left
            if (arr[i] != i + 1 && arr[i + 1] == i + 1) {
                result = loopAndSwap(result, arr, i, 2);
                i = lastElementInCorrectPosition;
                continue;
            }
            // order is not correct && one to the right doesnt belongs left
            if (arr[i] != i + 1 && arr[i + 1] != i + 1) {
                result = loopAndSwap(result, arr, i, 1);
                i = lastElementInCorrectPosition;
            }
        }
        System.out.println(Arrays.toString(arr));
        return result;
    }

    private static int loopAndSwap(int result, int[] arr, int i, int i2) {
        for (int j = i + 1; j < arr.length; j++) {
            if (arr[j] == i + i2) {
                swapArrElements(arr, j, i);
                result++;
                break;
            }
        }
        return result;
    }

    private static void swapArrElements(int[] arr, int i, int j) {
        int swap = arr[i];
        arr[i] = arr[j];
        arr[j] = swap;
    }
}
