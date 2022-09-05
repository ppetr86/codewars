package com.example.codewars3.hackerRank;

import java.util.Arrays;

public class BigSum {

    public static void main(String[] args) {
        System.out.println(aVeryBigSum(new long[]{1000000001, 1000000002, 1000000003, 1000000004, 1000000005}));
    }

    static long aVeryBigSum(long[] ar) {
        return Arrays.stream(ar).sum();
    }
}
