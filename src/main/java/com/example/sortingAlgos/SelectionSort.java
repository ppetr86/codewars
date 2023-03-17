package com.example.sortingAlgos;

import java.util.Arrays;

public class SelectionSort {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(selectionSort(new int[]{3, 5, 7, 8, 4, 2, 1, 9, 6})));
    }

    private static int[] selectionSort(int[] ints) {
        for (int i = 0; i < ints.length; i++) {
            // set minimum to current
            // hold the index
            int min = ints[i];
            int index = i;
            for (int j = i + 1; j < ints.length; j++) {
                //find minimum compared to previous min
                if (ints[j] < min) {
                    min = ints[j];
                    index = j;
                }
            }
            //swap current with found to the index of I and index of found min
            int holder = ints[i];
            ints[i] = min;
            ints[index] = holder;
        }
        return ints;
    }
}