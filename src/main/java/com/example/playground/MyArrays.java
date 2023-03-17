package com.example.playground;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class MyArrays {

    public static void main(String[] args) {
        int[][] arr = new int[][]{
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}};
        System.out.println(Arrays.deepToString(rotateLeft(arr)));
        System.out.println(Arrays.deepToString(rotateLeftAndSwitchRows(arr)));

        System.out.println(Arrays.deepToString(rotateRight(arr)));

        System.out.println(hourglass(new int[][]{
                {-9, -9, -9, 1, 1, 1},
                {0, -9, 0, 4, 3, 2},
                {-9, -9, -9, 1, 2, 3},
                {0, 0, 8, 6, 6, 0},
                {0, 0, 0, -2, 0, 0},
                {0, 0, 1, 2, 4, 0}}));

        System.out.println(Arrays.deepToString(ascending(0, 5)));

        System.out.println(Arrays.toString(letterCounterInArr("count the letters in this string in some nice way")));

    }

    private static int[] letterCounterInArr(String str) {
        int[] result = new int[26];
        for (int i = 0; i < str.length(); i++) {
            if (Character.isLetter(str.charAt(i))) {
                result[str.charAt(i) - 'a']++;
            }
        }

        Map<String, Long> letterCounter = Arrays.stream(str.split("")).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println(letterCounter);

        return result;
    }

    private static int[][] ascending(int i, int arrLen) {
        int[][] result = new int[arrLen][arrLen];
        for (int j = 0; j < arrLen; j++) {
            for (int k = 0; k < arrLen; k++) {
                result[j][k] = i++;
            }
        }
        return result;
    }

    private static int hourglass(int[][] ints) {
        int result = 0;

        for (int i = 0; i < ints.length - 3; i++) {
            for (int j = 0; j < ints[i].length - 3; j++) {
                int topRow = Arrays.stream(ints[i]).skip(j).limit(3).sum();
                int middleRow = ints[i + 1][j + 1];
                int bottomRow = Arrays.stream(ints[i + 2]).skip(j).limit(3).sum();

                result = Math.max(result, topRow + middleRow + bottomRow);
            }
        }

        return result;
    }

    private static int[][] rotateRight(int[][] arr) {
        int[][] result = new int[arr.length][arr.length];

        //7,4,1
        //8,5,2
        //9,6,3

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                result[i][j] = arr[arr.length - 1 - j][i];
            }
        }

        return result;
    }

    private static int[][] rotateLeftAndSwitchRows(int[][] arr) {
        int[][] result = new int[arr.length][arr.length];

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                result[i][j] = arr[j][i];
            }
        }
        return result;
    }

    private static int[][] rotateLeft(int[][] arr) {
        int[][] result = new int[arr.length][arr.length];

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                result[i][j] = arr[j][arr.length - 1 - i];
            }
        }
        return result;
    }

}