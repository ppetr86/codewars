package com.example.codewars3.hackerRank.algosEasy;

import java.util.List;

//https://www.hackerrank.com/challenges/breaking-best-and-worst-records/problem?isFullScreen=true
public class BreakingRecords {

    public static void main(String[] args) {
        System.out.println(breakingRecords(List.of(3, 4, 21, 36, 10, 28, 35, 5, 24, 42)));
    }

    public static List<Integer> breakingRecords(List<Integer> scores) {
        int maxSoFar = scores.get(0);
        int minSoFar = scores.get(0);
        int maxCounter = 0;
        int minCounter = 0;

        for (int i = 1; i < scores.size(); i++) {
            if (scores.get(i) < minSoFar) {
                minSoFar = scores.get(i);
                minCounter++;
            }
            if (scores.get(i) > maxSoFar) {
                maxSoFar = scores.get(i);
                maxCounter++;
            }
        }
        return List.of(maxCounter, minCounter);
    }
}
