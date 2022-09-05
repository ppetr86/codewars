package com.example.codewars3.codewars.kyu6;

public class StringRotation {

    public static void main(String[] args) {
        String s1 = "coffee";
        String s2 = "eecoff";
        System.out.println(shiftedDiff(s1, s2));
        System.out.println(shiftedDiffV(s1, s2));
    }

    private static int shiftedDiffV(String s1, String s2) {
        if (s1.length() != s2.length()) return -1;
        s2 += s2;
        return s2.indexOf(s1);
    }

    static int shiftedDiff(String first, String second) {
        if (first.length() != second.length()) return -1;
        if (first.equals(second)) return 0;
        String secondShifted = second;
        int counter = 1;

        for (int i = 0; i < second.length(); i++) {
            secondShifted = shiftWord(secondShifted);
            if (first.equals(secondShifted)) return counter;
            counter++;
        }
        return -1;
    }

    private static String shiftWord(String str) {
        return str.substring(1) + str.charAt(0);
    }


}