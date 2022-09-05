package com.example.codewars3.codewars.kyu5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HowManyNumbers {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(maxSumDig(4000, 4)));
    }

    private static Boolean valid(long num, int maxsm) {
        String str = String.valueOf(num);
        for (int i = 0; i <= str.length() - 4; i++) {
            int sum = 0;
            for (int j = i; j < i + 4; j++) {
                sum += str.charAt(j) - '0';
                if (sum > maxsm) {
                    return false;
                }
            }
        }
        return true;
    }

    public static long[] maxSumDig(long nmax, int maxsm) {
        List<Integer> sumDigit = new ArrayList<>();
        for (int i = 1000; i <= nmax; i++) {
            if (valid(i, maxsm)) {
                sumDigit.add(i);
            }
        }

        int sum = sumDigit.stream().reduce(0, Integer::sum);
        double avg = (double) sum / sumDigit.size();

        int theClosest = sumDigit.get(0);
        double diffToAvg = Math.abs(avg - theClosest);

        for (int i = 1; i < sumDigit.size(); i++) {
            if (Math.abs(sumDigit.get(i) - avg) == diffToAvg) {
                if (theClosest > sumDigit.get(i)) theClosest = sumDigit.get(i);
            }
            if (Math.abs(sumDigit.get(i) - avg) < diffToAvg) {
                theClosest = sumDigit.get(i);
                diffToAvg = Math.abs(sumDigit.get(i) - avg);
            }
        }

        return new long[]{sumDigit.size(), theClosest, sum};
    }
}
