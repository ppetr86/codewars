package com.example.hackerRank;

import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
        countSwaps(new int[]{3, 2, 1});
    }

    private static void countSwaps(int[] ints) {
        int counter = 0;

        for (int i = 0; i < ints.length; i++) {

            for (int j = 0; j < ints.length - 1; j++) {
                // Swap adjacent elements if they are in decreasing order
                if (ints[j] > ints[j + 1]) {
                    int holder = ints[j];
                    ints[j] = ints[j + 1];
                    ints[j + 1] = holder;
                    counter++;
                }
            }
        }

        int min = Arrays.stream(ints).min().orElse(0);
        int max = Arrays.stream(ints).max().orElse(0);


        System.out.println("Array is sorted in " + counter + " swaps.\n" +
                "First Element: " + min + "\n" +
                "Last Element: " + max);
    }
}
