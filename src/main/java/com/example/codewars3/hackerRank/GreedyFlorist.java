package com.example.codewars3.hackerRank;

import java.util.Arrays;

public class GreedyFlorist {

    public static void main(String[] args) {
        System.out.println(getMinimumCost(3, new int[]{1, 3, 5, 7, 9}));
    }

    static int getMinimumCost(int k, int[] c) {
        Arrays.sort(c);
        int[] remainder = Arrays.stream(c).limit(c.length - k).toArray();
        int result = Arrays.stream(c).skip(c.length - k).sum();
        for (int i = 0; i < remainder.length; i++) {
            result += remainder[i] * (1 + 1);
        }

        return result;
    }
}
