package codewars.kyu5;
//https://www.codewars.com/kata/550f22f4d758534c1100025a/train/java

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class DirReduction {

  public static void main(String[] args) {
    System.out.println(Arrays.toString(dirReduc(new String[]{"SOUTH", "NORTH", "SOUTH", "EAST", "WEST", "NORTH", "WEST"})));
  }

  public static String[] dirReduc(String[] arr) {

    List<String> result = Arrays.stream(arr).collect(Collectors.toList());

    for (int i = 0; i < result.size() - 1; i++) {
      if ((result.get(i).equals("NORTH") && result.get(i + 1).equals("SOUTH")) ||
              (result.get(i).equals("SOUTH") && result.get(i + 1).equals("NORTH")) ||
              (result.get(i).equals("EAST") && result.get(i + 1).equals("WEST")) ||
              (result.get(i).equals("WEST") && result.get(i + 1).equals("EAST"))) {
        result.remove(i + 1);
        result.remove(i + 0);
        i = -1;
      }
    }

    return result.toArray(String[]::new);
  }
}