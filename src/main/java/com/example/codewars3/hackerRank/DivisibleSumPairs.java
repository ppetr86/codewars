package com.example.codewars3.hackerRank;

//https://www.hackerrank.com/challenges/divisible-sum-pairs/problem
public class DivisibleSumPairs {

    public static void main(String[] args) {
        System.out.println(divisibleSumPairs(6, 3, new int[]{1, 3, 2, 6, 1, 2}));
    }

    static int divisibleSumPairs(int n, int k, int[] ar) {
        int result = 0;

        for (int i = 0; i < ar.length - 1; i++) {
            int current = ar[i];
            for (int j = i + 1; j < ar.length; j++) {
                int next = ar[j];
                if ((current + next) % k == 0) result++;
            }
        }
        return result;
    }
}
