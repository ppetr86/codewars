package com.example.codewars.kyu6;

import java.util.Arrays;

public class NutFarm {
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
        while (row < tree.length) {
            if (row == tree.length - 1) {
                resultArray[col] = resultArray[col] + 1;
                return;
            }
            char c = tree[row][col];
            if (tree[row][col] == '.' || tree[row][col] == '|' || tree[row][col] == ' ') {
                row++;
            } else if (tree[row][col] == '/') {
                col--;
                row++;
            } else if (tree[row][col] == '\\') {
                col++;
                row++;
            } else if (tree[row][col] == '_') {
                return;
            }
        }
    }
}
