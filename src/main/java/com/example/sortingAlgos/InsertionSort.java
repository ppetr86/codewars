package com.example.sortingAlgos;

import java.util.Arrays;

public class InsertionSort {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(insertionSortV2(new int[]{3, 5, 7, 8, 4, 2, 1, 9, 6})));

    }

    private static int[] insertionSortV2(int[] ints) {
        for (int i = 1; i < ints.length; i++) {
            // current is a holder for the current
            int current = ints[i];
            //index of previous
            int index = i - 1;
            // while current is smaller than previous
            while (index >= 0 && current < ints[index]) {
                //  swap elements right with left
                ints[index + 1] = ints[index];
                //go down with the swap until 0 index is reached or
                index--;
            }
            // at this point we've exited, so j is either -1
            // or it's at the first element where current >= a[j]
            ints[index + 1] = current;
        }

        return ints;
    }
}
