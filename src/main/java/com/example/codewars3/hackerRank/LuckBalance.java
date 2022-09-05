package com.example.codewars3.hackerRank;

import java.util.Arrays;
import java.util.Comparator;

public class LuckBalance {

    public static void main(String[] args) {
        System.out.println(luckBalance(3, new int[][]{{5, 1}, {2, 1}, {1, 1}, {8, 1}, {10, 0}, {5, 0}}));
    }

    static int luckBalance(int k, int[][] contests) {

        int result = 0;
        Arrays.sort(contests, new Comparator<int[]>() {
            public int compare(int[] o1, int[] o2) {
                // minus 1 for decreasing
                return -1 * Integer.compare(o1[0], o2[0]);
            }
        });

        for (int i = 0; i < contests.length; i++) {
            int luck = contests[i][0];
            int importance = contests[i][1];
            if (importance == 0) result += luck;
            if (importance == 1 && k == 0) {
                result -= luck;
            } else if (importance == 1 && k > 0) {
                result += luck;
                k--;
            }

        }

        return result;
    }
}
