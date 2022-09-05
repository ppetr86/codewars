package com.example.codewars3.hackerRank;

public class Clouds {
    public static void main(String[] args) {
        System.out.println(jumpingOnClouds(new int[]{0, 1, 0, 0, 0, 1, 0}));
    }

    private static int jumpingOnClouds(int[] ints) {
        int counter = 0;
        for (int i = 0; i < ints.length; i++) {
            if (i + 2 < ints.length && ints[i + 2] == 0) {
                counter++;
                i++;
            } else {
                counter++;
            }
        }
        counter--;
        return counter;
    }
}
