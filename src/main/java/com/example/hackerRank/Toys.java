package com.example.hackerRank;

import java.util.Arrays;

public class Toys {
    public static void main(String[] args) {
        System.out.println(maximumToys(new int[]{1, 12, 5, 111, 200, 1000, 10}, 20));
    }

    static int maximumToys(int[] prices, int k) {
        int result = 0;
        Arrays.sort(prices);

        for (int each : prices) {
            if (k - each <= 0) break;
            k -= each;
            result++;
        }

        return result;
    }
}
