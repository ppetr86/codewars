package com.example.codewars3.sortingAlgos;

import java.util.Arrays;

public class BubbleSort {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(bubbleSort(new int[]{9, 8, 7, 6, 5, 4, 3, 2, 1})));
    }

    //time complexity O(n^2)
    private static int[] bubbleSort(int[] ints) {

        boolean sorted = false;
        while (!sorted) {
            sorted = true;
            for (int i = 0; i < ints.length - 1; i++) {
                if (ints[i] > ints[i + 1]) {
                    int holder = ints[i];
                    ints[i] = ints[i + 1];
                    ints[i + 1] = holder;
                    sorted = false;
                }
            }
        }
        return ints;
    }
}