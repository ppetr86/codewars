package com.example.codewars3.codewars.kyu6;

import java.util.Arrays;
import java.util.Comparator;

//https://www.codewars.com/kata/57eb8fcdf670e99d9b000272/train/java
public class HighestScoringWord {

    public static void main(String[] args) {
        System.out.println(high("aaa bbb ccc ddd zzz"));
    }

    public static String high(String s) {
        StringBuilder currentStr = new StringBuilder();
        StringBuilder highestStr = new StringBuilder();
        int highestScore = 0;
        int currentScore = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != ' ') {
                currentStr.append(s.charAt(i));
                currentScore += s.charAt(i) - 96;
            }
            if (s.charAt(i) == ' ' || i == s.length() - 1) {
                if (currentScore > highestScore) {
                    highestScore = currentScore;
                    highestStr = currentStr;
                }
                currentStr = new StringBuilder();
                currentScore = 0;
            }
        }
        return highestStr.toString();
    }

    public static String highV2(String s) {
        return Arrays.stream(s.split(" "))
                .max(Comparator.comparingInt(
                        a -> a.chars().map(i -> i - 96).sum()
                )).get();
    }

}