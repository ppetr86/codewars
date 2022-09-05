package com.example.codewars3.hackerRank;

public class Climber {
    public static void main(String[] args) {
        System.out.println(climb(8, "DDUUUUDD"));
    }

    private static int climb(int steps, String path) {
        int counter = 0;
        int altitude = 0;

        for (int i = 0; i < path.length(); i++) {
            if (path.charAt(i) == 'D') altitude--;
            if (path.charAt(i) == 'U') {
                altitude++;
                if (altitude == 0) counter++;
            }
        }
        return counter;
    }
}
