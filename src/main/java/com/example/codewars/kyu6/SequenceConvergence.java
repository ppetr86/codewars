package com.example.codewars.kyu6;
//https://www.codewars.com/kata/59971e64bfccc70748000068/train/java

import java.util.HashSet;
import java.util.Set;

public class SequenceConvergence {

    public static void main(String[] args) {
        System.out.println(convergence(3));
    }

    public static int convergence(int n) {

        int counter = 0;
        int length = 1;
        int lastFromBaseArr = 1;
        int lastFromConvergenceArr = n;

        Set<Integer> baseSet = new HashSet<>();
        Set<Integer> convergenceSet = new HashSet<>();
        baseSet.add(lastFromBaseArr);
        convergenceSet.add(lastFromConvergenceArr);

        for (int i = 1; i <= length; i++) {
            if (!convergenceSet.contains(lastFromBaseArr)) {
                lastFromConvergenceArr = calculateNext(lastFromConvergenceArr);

                lastFromBaseArr = calculateNextForBaseSet(lastFromBaseArr, baseSet, lastFromConvergenceArr);
                length++;
                counter++;
            } else {
                break;
            }
        }
        return counter;
    }

    private static int calculateNextForBaseSet(int lastFromBaseArr, Set<Integer> baseSet, int lastFromConvergenceArr) {


        while (lastFromBaseArr < lastFromConvergenceArr) {

            lastFromBaseArr = calculateNext(lastFromBaseArr);
            baseSet.add(lastFromBaseArr);
        }
        return lastFromBaseArr;
    }

    private static int calculateNext(int input) {
        if (input < 10) return input * 2;
        String nrToLetter = String.valueOf(input);
        int multiply = 1;
        for (int j = 0; j < nrToLetter.length(); j++) {
            int parsed = Integer.parseInt(nrToLetter.substring(j, j + 1));
            if (parsed == 0) continue;
            multiply *= parsed;
        }

        return input + multiply;
    }
}
