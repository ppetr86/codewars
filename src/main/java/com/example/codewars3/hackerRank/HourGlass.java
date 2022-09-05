package com.example.codewars3.hackerRank;
//https://www.hackerrank.com/challenges/2d-array/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=arrays

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class HourGlass {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        System.out.println(hourglassSum(new int[][]{
                {-9, -9, -9, 1, 1, 1},
                {0, -9, 0, 4, 3, 2},
                {-9, -9, -9, 1, 2, 3},
                {0, 0, 8, 6, 6, 0},
                {0, 0, 0, -2, 0, 0},
                {0, 0, 1, 2, 4, 0}}));
    }

    // Complete the hourglassSum function below.

  /*static int hourglassSum(int[][] arr) {
    int result = Integer.MIN_VALUE;
    int sumOfThisRun = 0;

    for (int i = 0; i < arr.length - 2; i++) {
      for (int j = 0; j < arr[i].length - 2; j++) {

        int sum1 = arr[i][j] + arr[i][j+1] + arr[i][j+2];
        int sum2 = arr[i+1][j+1];
        int sum3 = arr[i+2][j] + arr[i+2][j+1] + arr[i+2][j+2];
        sumOfThisRun += sum3 + sum1 + sum2;

        if (sumOfThisRun > result) result = sumOfThisRun;
        sumOfThisRun = 0;
      }
    }
    return result;
  }*/

    static int hourglassSum(int[][] arr) {
        int result = Integer.MIN_VALUE;

        for (int i = 0; i < arr.length - 2; i++) {
            int sumOfThisRun = 0;
            for (int j = 0; j < arr[i].length - 2; j++) {

                int sum1 = Arrays.stream(arr[i]).skip(j).limit(3).sum();
                int sum2 = Arrays.stream(arr[i + 1]).skip(j + 1).limit(1).sum();
                int sum3 = Arrays.stream(arr[i + 2]).skip(j).limit(3).sum();

                sumOfThisRun += sum3 + sum2 + sum1;

                if (sumOfThisRun > result) result = sumOfThisRun;
            }
        }
        return result;
    }
}