package com.example.codewars3.companyTest.rdi;

public class SaddlePoint {
    public static void main(String[] args) {
        System.out.println(hasMatrixSaddlePoint(new int[][]{
                {1, 2, 3},
                {4, 5, 6},
                {9, 8, 9}}));
    }

    private static String hasMatrixSaddlePoint(int[][] input) {
        //an element that is the smallest in its row and the largest in its column
        boolean result = true;
        for (int i = 0; i < input.length; i++) {
            int minOfRow = input[i][0];
            int colIndexOfMin = 0;
            result = true;
            for (int j = 1; j < input[i].length; j++) {
                if (input[i][j] < minOfRow) {
                    colIndexOfMin = j;
                    minOfRow = input[i][j];
                }
            }
            for (int j = 0; j < input.length; j++) {
                if (input[i][j] < colIndexOfMin) {
                    result = false;
                    break;
                }
            }
        }
        return result ? "YES" : "NO";
    }
}
