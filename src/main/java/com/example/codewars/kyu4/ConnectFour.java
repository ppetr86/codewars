package com.example.codewars.kyu4;
//https://www.codewars.com/kata/56882731514ec3ec3d000009/train/java
//https://www.codewars.com/kata/56882731514ec3ec3d000009/solutions/java

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.joining;

public class ConnectFour {

    public static void main(String[] args) {
        List<String> myList = new ArrayList<String>(Arrays.asList("A_Yellow", "B_Red", "B_Yellow", "C_Red", "G_Yellow", "C_Red", "C_Yellow", "D_Red", "G_Yellow", "D_Red", "G_Yellow", "D_Red", "F_Yellow", "E_Red", "D_Yellow"));

        List<String> failing = new ArrayList<>(Arrays.asList(
                "B_Yellow", "D_Red", "B_Yellow", "A_Red", "B_Yellow", "G_Red",
                "F_Yellow", "E_Red", "G_Yellow", "E_Red", "G_Yellow", "G_Red",
                "A_Yellow", "E_Red", "C_Yellow", "F_Red", "F_Yellow", "A_Red",
                "A_Yellow", "B_Red", "F_Yellow", "D_Red", "A_Yellow", "E_Red",
                "F_Yellow", "D_Red", "D_Yellow", "D_Red", "A_Yellow", "D_Red",
                "F_Yellow", "B_Red", "B_Yellow", "G_Red", "G_Yellow", "E_Red",
                "C_Yellow", "E_Red", "C_Yellow", "C_Red", "C_Yellow", "C_Red"));

        List<String> failing2 = new ArrayList<>(Arrays.asList("F_Yellow", "G_Red", "D_Yellow", "C_Red", "A_Yellow", "A_Red",
                "E_Yellow", "D_Red", "D_Yellow", "F_Red", "B_Yellow", "E_Red", "C_Yellow", "D_Red", "F_Yellow",
                "D_Red", "D_Yellow", "F_Red", "G_Yellow", "C_Red", "F_Yellow", "E_Red", "A_Yellow", "A_Red",
                "C_Yellow", "B_Red", "E_Yellow", "C_Red", "E_Yellow", "G_Red", "A_Yellow", "A_Red", "G_Yellow",
                "C_Red", "B_Yellow", "E_Red", "F_Yellow", "G_Red", "G_Yellow", "B_Red", "B_Yellow", "B_Red"));

        List<String> failing3 = new ArrayList<>(Arrays.asList("D_Yellow", "G_Red", "D_Yellow", "E_Red", "A_Yellow", "B_Red", "G_Yellow", "A_Red", "G_Yellow", "E_Red", "A_Yellow", "B_Red", "D_Yellow", "E_Red", "F_Yellow", "G_Red", "B_Yellow", "A_Red", "C_Yellow", "G_Red", "G_Yellow", "F_Red", "A_Yellow", "A_Red", "F_Yellow", "C_Red", "B_Yellow", "D_Red", "F_Yellow", "D_Red", "F_Yellow", "C_Red", "E_Yellow", "D_Red", "C_Yellow", "F_Red", "E_Yellow", "E_Red", "B_Yellow", "C_Red", "C_Yellow", "B_Red"));

        List<String> failing4 = new ArrayList<>(List.of("D_Yellow", "D_Red", "C_Yellow", "F_Red", "D_Yellow", "A_Red", "C_Yellow", "G_Red", "C_Yellow", "E_Red", "G_Yellow", "F_Red", "C_Yellow", "G_Red", "D_Yellow", "A_Red", "F_Yellow", "F_Red", "A_Yellow", "B_Red", "E_Yellow", "F_Red", "G_Yellow", "G_Red", "G_Yellow", "E_Red", "F_Yellow", "B_Red", "D_Yellow", "C_Red", "C_Yellow", "A_Red", "A_Yellow", "A_Red", "D_Yellow", "E_Red", "B_Yellow", "E_Red", "E_Yellow", "B_Red", "B_Yellow", "B_Red"));
        List<String> failing5 = new ArrayList<>(List.of("F_Yellow", "F_Red", "B_Yellow", "B_Red", "G_Yellow", "B_Red", "C_Yellow", "E_Red", "C_Yellow", "B_Red", "D_Yellow", "D_Red", "D_Yellow", "F_Red", "F_Yellow", "F_Red", "A_Yellow", "G_Red", "D_Yellow", "G_Red", "A_Yellow", "F_Red", "A_Yellow", "C_Red", "C_Yellow", "D_Red", "B_Yellow", "A_Red", "A_Yellow", "C_Red", "A_Yellow", "B_Red", "G_Yellow", "E_Red", "D_Yellow", "G_Red", "E_Yellow", "C_Red", "G_Yellow", "E_Red", "E_Yellow", "E_Red"));
        List<String> failing6 = new ArrayList<>(List.of("E_Yellow", "A_Red", "F_Yellow", "D_Red", "D_Yellow", "F_Red", "B_Yellow", "F_Red", "E_Yellow", "D_Red", "F_Yellow", "C_Red", "F_Yellow", "G_Red", "D_Yellow", "G_Red", "B_Yellow", "D_Red", "G_Yellow", "D_Red", "F_Yellow", "C_Red", "C_Yellow", "G_Red", "A_Yellow", "G_Red", "G_Yellow", "E_Red", "A_Yellow", "A_Red", "E_Yellow", "C_Red", "B_Yellow", "E_Red", "A_Yellow", "A_Red", "B_Yellow", "C_Red", "C_Yellow", "E_Red", "B_Yellow", "B_Red"));


        System.out.println(whoIsWinner(failing5));

    }

    public static String whoIsWinner(List<String> piecesPositionList) {
        //System.out.println(piecesPositionList);
        StringBuilder result = new StringBuilder();
        String[][] playField = new String[6][7];
        for (String[] row : playField) {
            Arrays.fill(row, "Empty");
        }
        createPlayFieldFromPositions(piecesPositionList, result, playField);
        return result.toString().isEmpty() ? "Draw" : result.toString();
    }

    private static void evaulatePlayField(String[][] playField, StringBuilder result, int row, int col) {
        String horizontal = String.join("", playField[row]);
        if (horizontal.contains("YellowYellowYellowYellow")) {
            result.append("Yellow");
            return;
        } else if (horizontal.contains("RedRedRedRed")) {
            result.append("Red");
            return;
        }
        String vertical = Arrays.stream(playField).map(arrRow -> arrRow[col]).collect(joining());
        if (vertical.contains("YellowYellowYellowYellow")) {
            result.append("Yellow");
            return;
        } else if (vertical.contains("RedRedRedRed")) {
            result.append("Red");
            return;
        }
        String diagonal1 = getDiagonal1(playField, row, col);
        if (diagonal1.contains("YellowYellowYellowYellow")) {
            result.append("Yellow");
            return;
        } else if (diagonal1.contains("RedRedRedRed")) {
            result.append("Red");
            return;
        }
        String diagonal2 = getDiagonal2(playField, row, col);
        if (diagonal2.contains("YellowYellowYellowYellow")) {
            result.append("Yellow");
        } else if (diagonal2.contains("RedRedRedRed")) {
            result.append("Red");
        }
    }

    private static String getDiagonal2(String[][] playField, int row, int col) {
        StringBuilder result = new StringBuilder();
        int originalRow = row + 1;
        int originalCol = col - 1;

        while (row >= 0 && col < 7) {
            result.append(playField[row--][col++]);
        }

        while (originalRow < 6 && originalCol > 0) {
            result.insert(0, playField[originalRow++][originalCol--]);
        }
        return result.toString();
    }

    private static String getDiagonal1(String[][] playField, int row, int col) {
        StringBuilder result = new StringBuilder();
        int originalRow = row + 1;
        int originalCol = col + 1;

        while (row >= 0 && col >= 0) {
            result.insert(0, playField[row--][col--]);
        }

        while (originalRow < 6 && originalCol < 7) {
            result.append(playField[originalRow++][originalCol++]);
        }

        return result.toString();
    }

    private static void createPlayFieldFromPositions(List<String> piecesPositionList, StringBuilder result, String[][] playField) {

        int[] rowCounter = new int[7];
        for (int i = 0; i < piecesPositionList.size(); i++) {
            if (result.length() > 0) break;
            int row = rowCounter[piecesPositionList.get(i).charAt(0) - 'A']++;
            int col = piecesPositionList.get(i).charAt(0) - 'A';
            playField[Math.abs(row - 5)][col] = piecesPositionList.get(i).substring(2);
            if (i > 6) {
                evaulatePlayField(playField, result, Math.abs(row - 5), col);
                if (result.length() > 0) break;
            }
        }
    }
}