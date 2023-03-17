package com.example.entwicklerheld;

public class NumberOfIslands {

    private static int rowNr[] = new int[]{-1, 0, 0, 1};
    private static int colNbr[] = new int[]{0, -1, 1, 0};

    public static int numIslands(char[][] grid) {

        boolean visited[][] = new boolean[grid.length][grid[0].length];
        int count = 0;
        for (int i = 0; i < grid.length; ++i)
            for (int j = 0; j < grid[i].length; ++j)
                if (grid[i][j] == '1' && !visited[i][j]) {
                    traverseNeighbours(grid, i, j, visited);
                    ++count;
                }

        return count;
    }

    static void traverseNeighbours(char grid[][], int row, int col, boolean visited[][]) {
        visited[row][col] = true;

        for (int k = 0; k < 4; ++k)
            if (isOneInBoundsAndNotVisited(grid, row + rowNr[k], col + colNbr[k], visited))
                traverseNeighbours(grid, row + rowNr[k], col + colNbr[k], visited);
    }

    static boolean isOneInBoundsAndNotVisited(char grid[][], int row, int col, boolean visited[][]) {
        return (row >= 0) && (row < grid.length) && (col >= 0) && (col < grid[0].length) && (grid[row][col] == '1' && !visited[row][col]);
    }


    public static void main(String[] args) {
        System.out.println(numIslands(new char[][]{
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'},
        }));

        System.out.println(numIslands(new char[][]{
                {'0', '0', '0', '0'},
                {'0', '0', '0', '0'},
                {'0', '0', '0', '0'},
                {'0', '0', '0', '0'}
        }));

        System.out.println(numIslands(new char[][]{
                {'1', '1', '1', '1'},
                {'1', '1', '1', '1'},
                {'1', '1', '1', '1'},
                {'1', '1', '1', '1'}
        }));

        System.out.println(numIslands(new char[][]{
                {'1', '1', '1'},
                {'0', '1', '0'},
                {'1', '1', '1'}
        }));

        System.out.println(numIslands(new char[][]{
                {'1', '1', '0', '1'},
                {'0', '0', '0', '0'},
                {'0', '0', '0', '1'},
                {'1', '1', '0', '0'}
        }));
    }
}
