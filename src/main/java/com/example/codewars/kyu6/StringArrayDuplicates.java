package com.example.codewars.kyu6;

import java.util.Arrays;

public class StringArrayDuplicates {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(dup(new String[]{"ccooddddddewwwaaaaarrrrsssss", "piccaninny", "hubbubbubboo"})));
        System.out.println(Arrays.toString(dupV3(new String[]{"ccooddddddewwwaaaaarrrrsssss", "piccaninny", "hubbubbubboo"})));
    }

    public static String[] dup(String[] strings) {
        return Arrays.stream(strings).map(arr -> recursive(arr)).toArray(String[]::new);
    }

    public static String recursive(String toString) {
        if (toString.length() == 1) return toString;
        if (toString.charAt(0) == toString.charAt(1)) return recursive(toString.substring(1));
        return toString.charAt(0) + recursive(toString.substring(1));
    }

  /*public static String[] dup(String[] arr) {
    if (arr.length == 0) return new String[0];

    for (int i = 0; i < arr.length; i++) {
      String current = arr[i];
      StringBuilder sb = new StringBuilder();
      for (int j = 0; j < current.length() - 1; j++) {
        boolean isEqualChar = current.charAt(j) != current.charAt(j + 1);
        if (isEqualChar) sb.append(current.charAt(j));
      }
      sb.append(current.charAt(current.length() - 1));
      arr[i] = sb.toString();
    }

    return arr;
  }*/

    public static String[] dupV2(String[] arr) {
        return Arrays.stream(arr).map(w -> w.replaceAll("(.)\1+", "$1")).toArray(String[]::new);
    }

    public static String[] dupV3(String[] arr) {
        return Arrays.stream(arr)
                .map(word -> word.chars()
                        .mapToObj(a -> String.valueOf((char) a))
                        .reduce((a, b) -> a.substring(a.length() - 1).equals(b) ? a : a.concat(b))
                        .get())
                .toArray(String[]::new);
    }
}
