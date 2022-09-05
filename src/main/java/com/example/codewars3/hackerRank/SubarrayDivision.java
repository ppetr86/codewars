package com.example.codewars3.hackerRank;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class SubarrayDivision {
    public static void main(String[] args) {
        List<Integer> input = Arrays.asList(2, 2, 1, 3, 2);
        System.out.println(birthday(input, 4, 2));
    }

    // d = birth day
    // s = birth month
    //find segments which match in length s, and in sum d
    static int birthday(List<Integer> s, int d, int m) {
        int countOfMatches = 0;

        for (int i = 0; i < s.size() - m + 1; i++) {
            List<Integer> holder = s.stream().skip(i).limit(m).collect(Collectors.toList());
            int sum = holder.stream().reduce(0, Integer::sum);
            if (sum == d) {
                countOfMatches++;
            }
        }

        return countOfMatches;
    }
}