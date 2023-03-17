package com.example.codewars.kyu6;

import java.util.Arrays;

//https://www.codewars.com/kata/550554fd08b86f84fe000a58/solutions/java
public class WhichAreIn {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(inArray(new String[]{"arp", "live", "strong"}, new String[]{"lively", "alive", "harp", "sharp", "armstrong"})));
    }

  /*public static String[] inArray(String[] array1, String[] array2) {
    List<String> result = new ArrayList<>();
    for (int i = 0; i < array1.length; i++) {
      for (int j = 0; j < array2.length; j++) {
        if (array2[j].contains(array1[i])) {
          result.add(array1[i]);
          break;
        }
      }
    }
    return result.stream().distinct().sorted().toArray(String[]::new);
  }*/

    public static String[] inArray(String[] array1, String[] array2) {
        return Arrays.stream(array1)
                .filter(str ->
                        Arrays.stream(array2).anyMatch(s -> s.contains(str)))
                .distinct()
                .sorted()
                .toArray(String[]::new);
    }
}
