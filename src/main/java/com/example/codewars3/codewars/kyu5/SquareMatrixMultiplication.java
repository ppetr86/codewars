package com.example.codewars3.codewars.kyu5;
//https://www.codewars.com/kata/5263a84ffcadb968b6000513/train/java
//https://www.codewars.com/kata/5263a84ffcadb968b6000513/solutions/java

import java.util.Arrays;

public class SquareMatrixMultiplication {

    public static void main(String[] args) {
        int[][] a = {
                {1, 2, 1},
                {0, 1, 0},
                {2, 3, 4}};

        int[][] b = {
                {2, 5, 1},
                {6, 7, 1},
                {1, 8, 1}};
        System.out.println(Arrays.deepToString(matrixMultiplication(a, b)));
    }

    public static int[][] matrixMultiplication(int[][] a, int[][] b) {

        int[][] reversedB = new int[b.length][b[0].length];

        for (int i = 0; i < b.length; i++) {
            for (int j = 0; j < b[i].length; j++) {
                reversedB[i][j] = b[j][b.length - i - 1];
            }
        }

        System.out.println(Arrays.deepToString(reversedB));
        int[][] result = new int[a.length][a[0].length];

        for (int i = 0; i < result.length; i++) {
            int[] aRow = a[i];
            for (int j = 0; j < result[i].length; j++) {
                int[] bRow = reversedB[reversedB.length - 1 - j];
                result[i][j] = multipliedRows(aRow, bRow);
            }
        }
        return result;
    }

    private static int multipliedRows(int[] aRow, int[] bRow) {
        int result = 0;
        for (int i = 0; i < aRow.length; i++) {
            result += aRow[i] * bRow[i];
        }
        return result;
    }

    // Kond solution
    public static int[][] transpose(int[][] twoDimArr) {
        int row = twoDimArr.length;
        int column = twoDimArr[0].length;

        int[][] result = new int[column][row];

        for (int i = 0; i < column; i++) {
            int[] subResult = new int[row];
            for (int j = 0; j < row; j++) {
                subResult[j] = twoDimArr[j][i];
            }
            result[i] = subResult;
        }

        return result;
    }
}
