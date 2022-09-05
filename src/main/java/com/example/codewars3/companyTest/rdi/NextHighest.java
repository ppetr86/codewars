package com.example.codewars3.companyTest.rdi;

import java.util.Arrays;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.IntFunction;

public class NextHighest {

    private static AtomicInteger counter = new AtomicInteger();
    private static AtomicInteger functionCalls = new AtomicInteger();

    public static void main(String[] args) {
        System.out.println(nextHighestNumberWithSameDigits(1234)); // 1243
        System.out.println(nextHighestNumberWithSameDigits(199)); // 919
        System.out.println(nextHighestNumberWithSameDigits(919)); // 919
        System.out.println(nextHighestNumberWithSameDigits(1299)); // 1929
        System.out.println(nextHighestNumberWithSameDigits(198)); // 819
        System.out.println(nextHighestNumberWithSameDigits(-198)); // -189
        System.out.println(nextHighestNumberWithSameDigits(94_627_193)); // 94627319
        System.out.println(nextHighestNumberWithSameDigits(999_876_987)); // 999877689
        System.out.println(nextHighestNumberWithSameDigits(1_999_876_987)); // 1999877689
        System.out.println(nextHighestNumberWithSameDigits(100)); // 0
        System.out.println(nextHighestNumberWithSameDigits(9)); // 0
        System.out.println(nextHighestNumberWithSameDigits(11)); // 0
        System.out.println(nextHighestNumberWithSameDigits(111)); // 0
    }

    private static boolean isImpossibleToShuffleNumbers(int n) {
        return Math.abs(n) < 12 || new HashSet<>(Arrays.asList(String.valueOf(n).split(""))).size() < 2;
    }

    private static int nextHighestNumberWithSameDigits(int number) {
        if (isImpossibleToShuffleNumbers(number)) return 0;
        int optimizeFrom = 1_000_000_000;
        int optimized = number >= optimizeFrom ? number - optimizeFrom : number;
        PriorityQueue<Integer> permutations = new PriorityQueue<>();
        permutations(number, String.valueOf(Math.abs(optimized)), "", permutations);
//    System.out.printf("%d function calls: %d, permutations: %d\n", number, functionCalls.get(), counter.get());
//    functionCalls.set(0);
//    counter.set(0);
        try {
            return number < optimizeFrom ? permutations.peek() : permutations.peek() + optimizeFrom;
        } catch (NullPointerException e) {
            return 0;
        }
    }

    private static void permutations(int num, String remaining, String current, PriorityQueue<Integer> permutations) {
//    functionCalls.incrementAndGet();
        IntFunction<Integer> sign = num < 0 ? n -> -n : n -> n;

        if (remaining.length() == 0) {
            int permutation = sign.apply(Integer.parseInt(current));
//      System.out.printf("%d permutation: %d\n", num, permutation);
//      counter.incrementAndGet();
            if (permutation != num && !permutations.contains(permutation)) permutations.add(permutation);
            return;
        }
        for (int i = 0; i < remaining.length(); i++) {
            try {
                String nextRemaining = remaining.substring(0, i) + remaining.substring(i + 1);
                String nextChar = String.valueOf(remaining.charAt(i));
                String nextVariation = current + nextChar;
                Integer nextVariationNum = sign.apply(Integer.valueOf(nextVariation));
                Integer sameLengthNum = sign.apply(Integer.valueOf(String.valueOf(Math.abs(num)).substring(0, nextVariation.length())));
                Integer sameLengthPerm = permutations.isEmpty() ? Integer.MAX_VALUE : permutations.peek();
                if (nextVariationNum >= sameLengthNum && nextVariationNum <= sameLengthPerm) {
                    permutations(num, nextRemaining, current + nextChar, permutations);
                }
            } catch (Exception e) {
                continue;
            }
        }
    }

}