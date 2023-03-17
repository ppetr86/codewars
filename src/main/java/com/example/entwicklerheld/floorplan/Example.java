package com.example.entwicklerheld.floorplan;

public class Example {
    static boolean[][] createExample2() {
        return new boolean[2][2];
    }

    static boolean[][] createExample() {
        boolean[][] result = new boolean[10][10];
        int counter = 0;
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[i].length; j++) {
                if (counter++ < 10) {
                    result[i][j] = true;
                }
            }
        }
        return result;
    }
}
