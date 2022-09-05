package com.example.codewars3.codewars;

public class CalculateRotation {

    public static void main(String[] args) {
        System.out.println(shiftedDiff("eecoff", "coffee"));
    }

    static int shiftedDiff(String first, String second) {
        if (first.length() != second.length()) return -1;
        if (first.equals(second)) return 0;
        int counter = 1;

        for (int i = 0; i < second.length(); i++) {
            second = shiftWord(second);
            if (first.equals(second)) return counter;
            counter++;
        }
        return -1;
    }

    private static String shiftWord(String str) {
        return str.substring(1) + str.charAt(0);
    }
}

/*public class CalculateRotation {
  static int shiftedDiff(String first, String second){
    if (first.length() != second.length())
      return -1;
    return (second + second).indexOf(first);
  }
}*/
