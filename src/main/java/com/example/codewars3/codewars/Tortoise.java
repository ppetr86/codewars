package com.example.codewars3.codewars;

import java.util.Arrays;

//https://www.codewars.com/kata/55e2adece53b4cdcb900006c/train/java
public class Tortoise {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(race(720, 850, 70)));
    }

    public static int[] race(int v1, int v2, int g) {
        if (v1 > v2) return null;
        double result = (double) g / (v2 - v1);

        double tookSeconds = result * 60 * 60;

        int secs = (int) tookSeconds % 60;
        int mins = (int) tookSeconds / 60 % 60;
        int hrs = (int) tookSeconds / 3600;
        return new int[]{hrs, mins, secs};
    }
}