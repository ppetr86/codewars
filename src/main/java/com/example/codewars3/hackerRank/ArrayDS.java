package com.example.codewars3.hackerRank;

import java.util.Arrays;

public class ArrayDS {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(reverseArray(new int[]{1, 4, 3, 2})));
    }

    static int[] reverseArray(int[] a) {
        int[] result = new int[a.length];
        for (int i = 0; i < a.length; i++) {
            result[i] = a[a.length - 1 - i];
        }
        return result;
    }
}
