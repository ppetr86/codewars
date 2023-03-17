package com.example.hackerRank;

import java.util.regex.Pattern;

//https://www.hackerrank.com/challenges/alternating-characters/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=strings
public class AlternatingCharacters {
    // Complete the alternatingCharacters function below.

    static int alternatingCharacters(String s) {
        int result = 0;
        if (s.isEmpty()) return 0;
        if (Pattern.matches("[A]*", s) || Pattern.matches("[B]*", s)) return s.length() - 1;

        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) == s.charAt(i + 1))
                result++;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(alternatingCharacters("AAABBB"));
    }
}