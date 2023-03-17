package com.example.hackerRank;

import java.util.Arrays;

public class LeftRotation {

    // Complete the rotLeft function below.
    static int[] rotLeft(int[] arr, int d) {
        int[] result = new int[arr.length];

        for (int i = 0; i < arr.length; i++) {
            result[i] = arr[(i + d) % arr.length];
        }

        return result;
    }
    // 3,4,5,1,2

    public static void main(String[] args) {
        System.out.println(Arrays.toString(rotLeft(new int[]{1, 2, 3, 4, 5}, 3)));
    }
}
