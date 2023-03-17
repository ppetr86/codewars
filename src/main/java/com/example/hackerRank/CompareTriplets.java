package com.example.hackerRank;

import java.util.Arrays;
import java.util.List;

public class CompareTriplets {

    public static void main(String[] args) {
        List<Integer> alice = Arrays.asList(5, 6, 7);
        List<Integer> bob = Arrays.asList(3, 6, 10);
        System.out.println(compareTriplets(alice, bob));
    }

    // compare index i from both lists and count scores
    static List<Integer> compareTriplets(List<Integer> a, List<Integer> b) {
        int aScore = 0;
        int bScore = 0;

        for (int i = 0; i < a.size(); i++) {
            int comparisonResult = a.get(i).compareTo(b.get(i));

            if (comparisonResult == 1) aScore++;
            if (comparisonResult == -1) bScore++;
        }

        return Arrays.asList(aScore, bScore);
    }
}
