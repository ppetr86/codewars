package com.example.hackerRank;

//https://www.hackerrank.com/challenges/special-palindrome-again/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=strings
//A string is said to be a special string if either is met:
//All of the characters are the same, e.g. aaa.
//All characters except the middle one are the same, e.g. aadaa.
//how many special substrings can be formed
public class SpecialStringV4 {
    public static void main(String[] args) {
        System.out.println("mnonopoo");
        System.out.println(substrCount(4, "mnonopoo"));
        System.out.println("aaaa");
        System.out.println(substrCount(4, "aaaa"));
        System.out.println("asasd");
        System.out.println(substrCount(5, "asasd"));
        System.out.println("abcbaba");
        System.out.println(substrCount(7, "abcbaba"));
    }

    static long substrCount(int n, String s) {
        long result = n;

        for (int i = 0; i < s.length(); i++) {
            StringBuilder subStr = new StringBuilder(s.substring(i, i + 1));
            for (int j = i + 1; j < s.length(); j++) {
                char toAppend = s.charAt(j);
                subStr.append(toAppend);
                if (subStr.length() % 2 == 0) {
                    int count = subStr.chars().distinct().toString().length();
                    if (count == 1) result++;
                } else {
                    if (subStr.substring(0, subStr.length() / 2).equals(subStr.substring((subStr.length() / 2) + 1))) {
                        result++;
                    }
                }
            }
        }
        return result;
    }
}