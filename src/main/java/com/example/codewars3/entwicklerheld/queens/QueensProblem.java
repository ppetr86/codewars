package com.example.codewars3.entwicklerheld.queens;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class QueensProblem {
    /*public static boolean isSafeRook(List<Position> positions, Position rook) {
        for (Position position : positions) {
            if (position.rowIndex == rook.rowIndex || position.columnIndex == rook.columnIndex)
                return false;
        }
        return true;
    }*/

    public static boolean isSafeRook(List<Position> positions, Position rook) {
        return positions.stream()
                .noneMatch(position -> position.rowIndex == rook.rowIndex || position.columnIndex == rook.columnIndex);
    }

    /*public static boolean isSafeQueen(List<Position> positions, Position queen) {
        for (Position position : positions) {
            if (position.rowIndex == queen.rowIndex || position.columnIndex == queen.columnIndex)
                return false;
            if (Math.abs(position.rowIndex- queen.rowIndex) - Math.abs(position.columnIndex- queen.columnIndex)==0)
                return false;
        }
        return true;
    }*/

    public static boolean isSafeQueen(List<Position> positions, Position queen) {
        return positions.stream()
                .noneMatch(position -> position.rowIndex == queen.rowIndex
                        || position.columnIndex == queen.columnIndex
                        || Math.abs(position.rowIndex - queen.rowIndex) - Math.abs(position.columnIndex - queen.columnIndex) == 0);
    }

    public static List<Position> getQueensProblemSolution(int boardSize) {
        if (boardSize < 4) return new ArrayList<>();
        Position[] positions = new Position[boardSize];
        fillList(positions, 0, boardSize);
        return Arrays.asList(positions);
    }

    private static boolean fillList(Position[] placedQueens, int row, int boardSize) {
        if (boardSize == row) {
            return true;
        }
        int col;
        for (col = 0; col < boardSize; col++) {
            boolean isSafe = true;

            for (int queen = 0; queen < row; queen++) {
                if (placedQueens[queen].columnIndex == col
                        || placedQueens[queen].rowIndex - placedQueens[queen].columnIndex == row - col
                        || placedQueens[queen].rowIndex + placedQueens[queen].columnIndex == row + col) {
                    isSafe = false;
                    break;
                }
            }
            if (isSafe) {
                placedQueens[row] = new Position(row, col);
                if (fillList(placedQueens, row + 1, boardSize)) {
                    return true;
                }
            }
        }
        return false;
    }

    /*private static List<Position> fillList(ArrayList<Position> positions, int currentRow, int currentCol, int startRow, int startCol, int boardSize, Set<Integer> colCache) {
        //all found, stop
        if (positions.size() == boardSize)
            return positions;
        // define condition to start again
        if (currentCol > boardSize - 1) {
            currentRow += 1;
            currentCol = 0;
        } else if (currentRow > boardSize - 1) {
            startRow = startCol == boardSize - 1 ? startRow + 1 : startRow;
            startCol = startCol == boardSize - 1 ? 0 : startCol + 1;
            positions = new ArrayList<>();
            colCache = new HashSet<>();
            currentCol = startCol;
            currentRow = startRow;
        } else {
            Position newPosition = new Position(currentRow, currentCol);
            if (!colCache.contains(currentCol) && isSafeQueen(positions, newPosition)) {
                colCache.add(currentCol);
                positions.add(newPosition);
                currentRow = currentRow + 1;
                currentCol = 0;
                while (colCache.contains(currentCol)) {
                    currentCol += 1;
                    if (!colCache.contains(currentCol)) break;
                }
            } else {
                currentCol = currentCol == boardSize - 1 ? 0 : currentCol + 1;
                currentRow = currentCol == 0 ? currentRow + 1 : currentRow;
            }
        }
        return fillList(positions, currentRow, currentCol, startRow, startCol, boardSize, colCache);
    }*/

}
