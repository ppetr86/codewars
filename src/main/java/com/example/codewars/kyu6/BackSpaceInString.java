package com.example.codewars.kyu6;

public class BackSpaceInString {

    public static void main(String[] args) {
        System.out.println(cleanString("A A A###"));
    }

    public static String cleanString(String s) {
        StringBuilder sb = new StringBuilder();

        int counter = 0;

        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == '#') {
                counter++;
            } else if (s.charAt(i) != '#' && counter > 0) {
                i--;
                counter--;
            } else {
                sb.append(s.charAt(i));
            }
        }

        return sb.reverse().toString();
    }
}
