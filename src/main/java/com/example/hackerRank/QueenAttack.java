package com.example.hackerRank;

public class QueenAttack {

    public static void main(String[] args) {
        System.out.println(queensAttack(5, 3, 4, 3, new int[][]{{5, 5}, {4, 2}, {2, 3}}));
    }

    static int queensAttack(int boardLength, int countObstacles, int r_q, int c_q, int[][] obstacles) {
        int refactorRow = -8;
        int result = 0;
        r_q = Math.abs(r_q + refactorRow);
        for (int i = 0; i < obstacles.length; i++) {
            obstacles[i][0] = Math.abs(obstacles[i][0] + refactorRow);
        }

        result += countAttackable(r_q, c_q, obstacles);

        return result;
    }

    private static int countAttackable(int r_q, int c_q, int[][] obstacles) {
        return 0;
    }
}
