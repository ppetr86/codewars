package com.example.codewars3.hackerRank;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DiagonalDifference {

    public static void main(String[] args) {
        List<List<Integer>> arr = new ArrayList<>(3);
        arr.add(Arrays.asList(1, 2, 3));
        arr.add(Arrays.asList(4, 5, 6));
        arr.add(Arrays.asList(9, 8, 9));

        System.out.println(diagonalDifference(arr));
    }

  /*public static int diagonalDifference(List<List<Integer>> arr) {
    int diag1 = 0;
    int diag2 = 0;

    for (int i = 0; i < arr.size(); i++) {
      for (int j = 0; j < arr.get(i).size(); j++) {
        if (i==arr.size()-j-1) diag2 += arr.get(i).get(j);
        if (i == j) diag1 += arr.get(i).get(j);
      }
    }

    return Math.abs(diag1-diag2);
  }*/

    public static int diagonalDifference(List<List<Integer>> arr) {
        int diag1 = 0;
        int diag2 = 0;

        for (int i = 0; i < arr.size(); i++) {
            diag2 += arr.get(i).get(i);
            diag1 += arr.get(arr.size() - i - 1).get(i);
        }
        return Math.abs(diag1 - diag2);
    }
}
