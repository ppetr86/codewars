package com.example.hackerRank;

public class ArrayManipulation {

    public static void main(String[] args) {
        System.out.println(arrayManipulation(3, new int[][]{
                {1, 5, 3},
                {4, 8, 7},
                {6, 9, 1}}));
    }

    static Long arrayManipulation(int n, int[][] queries) {
        if (queries == null) return null;
        long[] array = initArr(10);
        long[] sumArr = executeQueries(queries, array);
        long max = findMax(sumArr);
        return max;
    }

    private static long[] initArr(int n) {
        return new long[n];
    }

    private static long[] executeQueries(int[][] queries, long[] array) {

        for (int[] query : queries) {
            for (int i = query[0] - 1; i < query[1]; i++) {
                array[i] += query[2];
            }
        }
        return array;
    }

    private static long findMax(long[] sumArr) {
        long max = Long.MIN_VALUE;
        for (long each : sumArr)
            max = Math.max(max, each);
        return max;
    }
}
