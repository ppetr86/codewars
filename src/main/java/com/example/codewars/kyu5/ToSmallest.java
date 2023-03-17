package com.example.codewars.kyu5;

import java.text.ParseException;
import java.util.Arrays;

public class ToSmallest {

    public static void main(String[] args) throws ParseException {
        //System.out.println(Arrays.toString(smallest(261235)));
        System.out.println(Arrays.toString(smallest(209917)));
        //System.out.println(Arrays.toString(smallest(296837)));
    }

    public static long[] smallest(long n) {

        String input = String.valueOf(n);
        long fromIndex = Integer.MAX_VALUE;
        long toIndex = Integer.MAX_VALUE;
        long minSoFar = n;

        for (int i = input.length() - 1; i >= 1; i--) {
            String atI = String.valueOf(input.charAt(i));
            for (int j = i - 1; j >= 0; j--) {
                if (i == j)
                    continue;
                String atJ = String.valueOf(input.charAt(j));
                String currentString = input.substring(0, j) + atI + atJ;
                if (i - j > 1)
                    currentString += input.substring(j + 1, i);
                if (i < input.length() - 1)
                    currentString += input.substring(i + 1);
                long currentLong = Long.parseLong(currentString);
                if (currentLong <= minSoFar) {
                    minSoFar = Math.min(currentLong, minSoFar);
                    fromIndex = currentString.indexOf(currentString.charAt(i));
                    toIndex = currentString.indexOf(currentString.charAt(j));
                }
            }
        }
        return new long[]{minSoFar, fromIndex, toIndex};
    }
}
