package com.example.entwicklerheld.walkingRobot;

import java.util.Arrays;
import java.util.HashMap;

public class WalkingRobot {

    public static void main(String[] args) {
        //Grid grid = new Grid(1, 1);
        //Grid grid2 = new Grid(2, 2);
        //Grid grid3 = new Grid(3, 3);
        //Grid grid4 = new Grid(12, 12);

        //System.out.println(uniquePaths(grid));
        //System.out.println(uniquePaths(grid2));
        //System.out.println("--------------");
        //System.out.println(uniquePaths(grid3));
        //System.out.println("--------------");
        //System.out.println(uniquePaths(grid4));

        /*Grid grid5 = new Grid(2, 2);
        grid5.setObstacle(0, 1);
        System.out.println(uniquePaths(grid5));*/

        Grid grid6 = new Grid(6, 3);
        grid6.setObstacle(1, 1);
        //System.out.println("--------------");
        //System.out.println(uniquePaths(grid6));
        System.out.println("--------------");
        /*System.out.println("--------------");
        Arrays.stream(pathMatrix(grid).getGrid()).forEach(each -> System.out.println(Arrays.toString(each)));
        System.out.println("--------------");
        Arrays.stream(pathMatrix(grid2).getGrid()).forEach(each -> System.out.println(Arrays.toString(each)));
        System.out.println("--------------");
        Arrays.stream(pathMatrix(grid3).getGrid()).forEach(each -> System.out.println(Arrays.toString(each)));*/
        //System.out.println("--------------");
        Arrays.stream(pathMatrix(grid6).getGrid()).forEach(each -> System.out.println(Arrays.toString(each)));
        System.out.println("--------------");
    }

    public static Grid pathMatrix(Grid board) {
        path(board);
        board.setValue(0, 0, 0);
        return board;
    }

    public static int recursiveCall(int row, int col, HashMap<String, Integer> rowColMap, Grid board) {
        String k = (row - 1) + " " + (col - 1);
        if (rowColMap.containsKey(k))
            return rowColMap.get(k);

        if (row == 1 && col == 1)
            return 1;
        if (row == 0 || col == 0 || board.getValue(row - 1, col - 1) == 0)
            return 0;

        int i1 = recursiveCall(row - 1, col, rowColMap, board);
        int i2 = recursiveCall(row, col - 1, rowColMap, board);
        rowColMap.put(k, i1 + i2);
        return rowColMap.get(k);
    }

    //it flips the matrix
    public static int recursiveCallPath(int row, int col, HashMap<String, Integer> rowColMap, Grid board) {
        String k = row + " " + col;
        if (rowColMap.containsKey(k))
            return rowColMap.get(k);

        if (row == board.getHeight() - 1 && col == board.getWidth() - 1)
            return 1;
        if (board.getValue(row, col) == 0)
            return 0;

        int i1 = 0;
        int i2 = 0;
        if (row + 1 < board.getHeight())
            i1 = recursiveCallPath(row + 1, col, rowColMap, board);
        if (col + 1 < board.getWidth())
            i2 = recursiveCallPath(row, col + 1, rowColMap, board);

        rowColMap.put(k, i1 + i2);
        return rowColMap.get(k);
    }

    public static int uniquePaths(Grid board) {
        return recursiveCall(board.getHeight(), board.getWidth(), new HashMap<>(), board);

    }

    private static int[][] path(Grid board) {
        board.setValue(0, 0, -1);
        //first col
        for (int i = 0; i < board.getHeight(); i++) {
            if (board.getGrid()[i][0] == -1)
                board.getGrid()[i][0] = 1;
            else {
                while (i < board.getHeight())
                    board.getGrid()[i++][0] = 0;
                break;
            }
        }

        //first row
        for (int i = 1; i < board.getWidth(); i++) {
            if (board.getGrid()[0][i] == -1)
                board.getGrid()[0][i] = 1;
            else {
                while (i < board.getWidth())
                    board.getGrid()[0][i++] = 0;
                break;
            }
        }

        //rest except first row and col
        for (int i = 1; i < board.getHeight(); i++) {
            for (int j = 1; j < board.getWidth(); j++) {
                if (board.getGrid()[i][j] != 0) {
                    int i1 = board.getGrid()[i - 1][j];
                    int i2 = board.getGrid()[i][j - 1];
                    if (board.getGrid()[i][j] == -1)
                        board.getGrid()[i][j]++;
                    board.getGrid()[i][j] += i1 + i2;
                }
            }
        }

        return board.getGrid();
    }

}
