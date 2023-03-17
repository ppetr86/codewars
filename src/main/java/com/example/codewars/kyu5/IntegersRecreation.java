package com.example.codewars.kyu5;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

//https://www.codewars.com/kata/55aa075506463dac6600010d/train/java
public class IntegersRecreation {

    public static void main(String[] args) {
        System.out.println(listSquared(42, 246));
    }

    public static String listSquared(long m, long n) {

        Set<Integer> divisors = new HashSet<>();
        Map<Integer, Integer> map = new HashMap<>();
        StringBuilder result = new StringBuilder();
        result.append("[");
        int sumOfSquares = 0;
        for (int i = (int) m; i <= n; i++) {
            if (n % i == 0) {
                divisors.add(i);
                map.put(i, i * i);
                sumOfSquares += i * i;
            }
        }

        boolean isSumSquare = isSquare(sumOfSquares);
    /*if (isSumSquare) {
      result.append("[").append(i).append(", ").append(i * i).append("], ");
    }*/

        //int sumOfSquaredDivisorsIsEqualToSum(sumOfSquares, map.values());

        return result.toString();
    }

    private static boolean isSquare(int sum) {
        double sq = Math.sqrt(sum);
        return ((sq - Math.floor(sq)) == 0);
    }
}
