package com.example.codewars.kyu6;

import java.util.Arrays;

//not avaialble in java
//https://www.codewars.com/kata/52fba2a9adcd10b34300094c/train/javascript
public class MatrixTranspose {

    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(transpose(new int[][]{{1, 2, 3}, {4, 5, 6}})));
        System.out.println(Arrays.deepToString(transposev3(new int[][]{{1, 2, 3}, {4, 5, 6}})));
    }

    public static int[][] transposev3(int[][] arr) {
        int[][] arrTransposed = new int[arr[0].length][arr.length];

        for (int i = 0; i < arr[0].length; i++) {
            for (int j = 0; j < arr.length; j++) {
                arrTransposed[i][j] = arr[j][i];
            }
        }
        return arrTransposed;
    }

    private static int[][] transpose(int[][] ints) {
        int[][] result = new int[ints[0].length][ints.length];

        int colCounter = 0, rowCounter = 0;

        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[0].length; j++) {
                result[i][j] = ints[rowCounter++][colCounter];
                if (j == result[0].length - 1) {
                    rowCounter = 0;
                    colCounter++;
                }
            }
        }
        return result;
    }

    //| 1 2 3 |
    //| 4 5 6 |

    //| 1 4 |
    //| 2 5 |
    //| 3 6 |

    private static int[][] transposeV2(int[][] ints) {
        int[][] result = new int[ints[0].length][ints.length];

        int colCounter = 0, rowCounter = -1;

        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[0].length; j++) {
                if (colCounter % ints[0].length == 0) {
                    colCounter = 0;
                    rowCounter++;
                }
                result[i][j] = ints[rowCounter][colCounter++];
            }
        }
        return result;
    }
}
