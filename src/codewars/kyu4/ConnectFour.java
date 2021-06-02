package codewars.kyu4;
//https://www.codewars.com/kata/56882731514ec3ec3d000009/train/java

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.joining;

public class ConnectFour {

  public static void main(String[] args) {
    List<String> myList = new ArrayList<String>(Arrays.asList(
            "A_Yellow",
            "B_Red",
            "B_Yellow",
            "C_Red",
            "G_Yellow",
            "C_Red",
            "C_Yellow",
            "D_Red",
            "G_Yellow",
            "D_Red",
            "G_Yellow",
            "D_Red",
            "F_Yellow",
            "E_Red",
            "D_Yellow"));
    
    List<String> failing = new ArrayList<>(Arrays.asList(
            "G_Yellow", "B_Red", "G_Yellow", "E_Red", "E_Yellow", "E_Red", "F_Yellow", "G_Red", "B_Yellow", "F_Red", "F_Yellow", "B_Red", "G_Yellow", "G_Red", "B_Yellow", "C_Red", "C_Yellow", "A_Red", "G_Yellow", "C_Red", "B_Yellow", "C_Red", "A_Yellow", "B_Red", "D_Yellow", "D_Red", "D_Yellow", "C_Red", "C_Yellow", "A_Red", "F_Yellow", "A_Red", "F_Yellow", "E_Red", "D_Yellow", "F_Red", "A_Yellow", "A_Red", "D_Yellow", "E_Red", "D_Yellow", "E_Red"
    ));
    System.out.println(whoIsWinner(myList));
  }

  public static String whoIsWinner(List<String> piecesPositionList) {
    System.out.println(piecesPositionList);
    StringBuilder result = new StringBuilder();
    String[][] playField = new String[6][7];
    for (String[] row : playField) {
      Arrays.fill(row, "Empty");
    }
    createPlayFieldFromPositions(piecesPositionList, result, playField);
    return result.toString().isEmpty() ? "Draw" : result.toString();
  }

  private static void evaulatePlayField(String[][] playField, StringBuilder result, int row, int col) {
    String horizontal = Arrays.stream(playField[row]).skip(Math.max(0, col - 3)).limit(Math.min(6, col + 3)).collect(joining());
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
    String diagonalUpToDown = getDiagonal(playField, row, col, -1,+1);
    if (diagonalUpToDown.contains("YellowYellowYellowYellow")) {
      result.append("Yellow");
      return;
    } else if (diagonalUpToDown.contains("RedRedRedRed")) {
      result.append("Red");
      return;
    }
    String diagonalDownToUp = getDiagonal(playField, row, col,-1,+1);
    if (diagonalDownToUp.contains("YellowYellowYellowYellow")) {
      result.append("Yellow");
    } else if (diagonalDownToUp.contains("RedRedRedRed")) {
      result.append("Red");
    }

    String diagonalUpToDownLtoR = getDiagonal(playField, row, col,+1,-1);
    if (diagonalUpToDownLtoR.contains("YellowYellowYellowYellow")) {
      result.append("Yellow");
      return;
    } else if (diagonalUpToDownLtoR.contains("RedRedRedRed")) {
      result.append("Red");
      return;
    }
    String diagonalDownToUpLtoR = getDiagonal(playField, row, col,-1,-1);
    if (diagonalDownToUpLtoR.contains("YellowYellowYellowYellow")) {
      result.append("Yellow");
    } else if (diagonalDownToUpLtoR.contains("RedRedRedRed")) {
      result.append("Red");
    }
  }

  private static String getDiagonal(String[][] playField, int row, int col, int changeRow, int changeCol) {
    String result = new String();
    while (row >= 0 && col >= 0) {
      result += playField[row + changeRow][col + changeCol];
    }
    return result;
  }

  private static String getDiagonalUpToDownLtoR(String[][] playField, int row, int col) {
    String result = new String();
    while (row < 6 && col >= 0) {
      result += playField[row++][col--];
    }
    return result;
  }

  private static String getDiagonalDownToUp(String[][] playField, int row, int col) {
    String result = new String();
    while (row >= 0 && col < 7) {
      result += playField[row--][col++];
    }
    return result;
  }

  private static String getDiagonalUpToDown(String[][] playField, int row, int col) {
    String result = new String();
    while (row < 6 && col < 7) {
      result += playField[row++][col++];
    }
    return result;
  }

  private static void createPlayFieldFromPositions(List<String> piecesPositionList, StringBuilder result, String[][] playField) {

    int[] rowCounter = new int[7];
    for (int i = 0; i < piecesPositionList.size(); i++) {
      if (result.length() > 0) break;
      String current = piecesPositionList.get(i);
      int row = rowCounter[piecesPositionList.get(i).charAt(0) - 'A']++;
      int col = piecesPositionList.get(i).charAt(0) - 'A';
      playField[Math.abs(row - 5)][col] = piecesPositionList.get(i).substring(2);
      if (i > 6) {
        evaulatePlayField(playField, result, Math.abs(row - 5), col);
        if (result.length() > 0) break;
      }
      if (i == piecesPositionList.size() - 1) result.append(current.substring(2));
    }
  }
}
