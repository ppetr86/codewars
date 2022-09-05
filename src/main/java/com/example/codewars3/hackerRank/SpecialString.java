package com.example.codewars3.hackerRank;

//https://www.hackerrank.com/challenges/special-palindrome-again/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=strings
//A string is said to be a special string if either is met:
//All of the characters are the same, e.g. aaa.
//All characters except the middle one are the same, e.g. aadaa.
//how many special substrings can be formed
public class SpecialString {
    public static void main(String[] args) {
        System.out.println(substrCount(4, "aaaa"));
    }

    static long substrCount(int n, String s) {
        long result = n;

        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 2; j < s.length() + 1; j++) {

                if (j - i != 3) {
                    if (s.charAt(i) != s.charAt(i + 1)) continue;
                }

                String str = s.substring(i, j);
                boolean sameLetters = special(str);
                if (sameLetters) result++;
            }
        }
        return result;
    }

    private static boolean special(String str) {

        if (str.length() % 2 != 0)
            str = str.substring(0, str.length() / 2) + str.substring(str.length() / 2 + 1);

        char[] charArr = str.toCharArray();
        for (int i = 0; i < charArr.length - 1; i++) {
            if (charArr[i] != charArr[i + 1]) return false;
        }
        return true;
    }
}
