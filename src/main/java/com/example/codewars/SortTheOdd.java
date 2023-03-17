package com.example.codewars;

import java.util.Arrays;

public class SortTheOdd {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(sortArray(new int[]{5, 3, 1, 8, 0})));
    }

    public static int[] sortArray(int[] array) {
        int[] odd = Arrays.stream(array).filter(nr -> nr % 2 != 0).sorted().toArray();
        int counter = 0;

        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 != 0) {
                array[i] = odd[counter];
                counter++;
            }
        }

        return array;
    }
}
