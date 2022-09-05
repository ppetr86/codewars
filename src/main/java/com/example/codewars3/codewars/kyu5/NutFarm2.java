package com.example.codewars3.codewars.kyu5;

import java.util.Arrays;

public class NutFarm2 {
//https://www.codewars.com/kata/59884371d1d8d3d9270000a5/train/java

    public static void main(String[] args) {

        char[][] arr1 = new char[][]
                {
                        {'.', 'o', '.', 'o', '.', 'o', '.', '.'},
                        {'.', '.', '/', '.', '.', '/', '.', '.'},
                        {'.', '.', '/', '.', '.', '/', '.', '.'}
                };

        System.out.println(Arrays.toString(shakeTree(arr1)));
    }

    public static int[] shakeTree(final char[][] tree) {
        int[] resultArray = new int[tree[0].length];
        for (int i = 0; i < tree.length; i++) {
            for (int j = 0; j < tree[i].length; j++) {
                if (tree[i][j] == 'o') {
                    calculateFall(resultArray, tree, i, j);
                }

            }
        }
        return resultArray;
    }

    private static void calculateFall(int[] resultArray, char[][] tree, int row, int col) {
        row++;
        boolean isLeft = false;
        boolean isRight = false;
        while (row < tree.length) {
            if (isLeft && isRight) {
                return;
            }
            if (row == tree.length - 1) {
                int indexFallOut = -1;
                if (canFallDown(tree[row], col, indexFallOut)) {
                    resultArray[indexFallOut] = resultArray[indexFallOut] + 1;
                    return;
                }
            }

        }
    }

    private static boolean canFallDown(char[] rowArr, int col, int indexFallOut) {
        if (rowArr[col] == '/') {
            for (int i = col - 1; 0 >= i; i--) {
                if (rowArr[i] == '\\') return false;
                if (rowArr[i] == '.' || rowArr[i] == '|' || rowArr[i] == ' ') {
                    indexFallOut = i;
                    return true;
                }
            }
        }
        return false;
    }
}

