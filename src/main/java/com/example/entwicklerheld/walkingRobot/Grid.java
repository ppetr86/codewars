package com.example.entwicklerheld.walkingRobot;

import java.util.Arrays;

public class Grid {

    private int width;
    private int height;
    private int[][] grid;

    public Grid(int w, int h) {
        this.width = w;
        this.height = h;
        grid = new int[height][width];

        for (int i = 0; i < height; i++) {
            Arrays.fill(grid[i], -1);
        }
    }

    public int[][] getGrid() {
        return grid;
    }

    public int getHeight() {
        return height;
    }

    public int[] getRow(int row) {
        return grid[row];
    }

    public int getValue(int row, int col) {
        return grid[row][col];
    }

    public int getWidth() {
        return width;
    }

    public void setObstacle(int row, int col) {
        grid[row][col] = 0;
    }

    public void setValue(int row, int col, int value) {
        grid[row][col] = value;
    }
}
