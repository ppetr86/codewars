package com.example.hackerRank.algosEasy;

public class Staircase {

    public static void main(String[] args) {
        staircase(6);
    }

    static void staircase(int n) {

        for (int i = 1; i <= n; i++) {
            StringBuilder space = new StringBuilder();
            for (int j = 1; j <= n - i; j++) {
                space.append(" ");
            }
            for (int j = 1; j <= i; j++) {
                space.append("#");
            }
            System.out.println(space.toString());
        }
    }

  /*static void staircase(int n) {

    for (int i = 1; i <= n; i++) {
      String space = " ".repeat(Math.max(0, n - i)) +
              "#".repeat(Math.max(0, i));
      System.out.println(space);
    }

  }*/
}
