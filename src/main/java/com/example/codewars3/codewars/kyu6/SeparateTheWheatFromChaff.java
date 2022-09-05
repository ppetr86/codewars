package com.example.codewars3.codewars.kyu6;
//https://www.codewars.com/kata/5bdcd20478d24e664d00002c/solutions/java

import java.util.Arrays;

public class SeparateTheWheatFromChaff {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(wheatFromChaff(new long[]{-7, -35, -46, -22, 46, 43, -44, -14, 34, -5, -26})));
        System.out.println(Arrays.toString(wheatFromChaff(new long[]{-16, 44, -7, -31, 9, -43, -44, -18, 50, 39, -46, -24, 3, -34, -27})));
    }

    public static long[] wheatFromChaff(long[] values) {

        long[] result = Arrays.copyOf(values, values.length);
        int[] negativesPositives = new int[2];
        for (int i = 0; i < values.length; i++) {
            if (values[i] > 0) {
                negativesPositives[1]++;
                long negative = findNegative(values, negativesPositives, i);
                if (negative == 0) break;
                result[result.length - negativesPositives[0]] = result[i];
                result[i] = negative;
            }
        }
        return result;
    }

    //negatives 0, positives1
    private static long findNegative(long[] values, int[] negativesPositives, int indexOfNegative) {

        for (int i = values.length - 1 - negativesPositives[0]; i >= 0; i--) {
            negativesPositives[0]++;
            if (values[i] < 0) {
                if (indexOfNegative >= i) return 0;
                return values[i];
            }
        }
        return 0;
    }

    public static long[] wheatFromChaffV2(long[] values) {
        long[] clone = values.clone();
        for (int i = 0; i < clone.length; i++) {
            if (clone[i] > 0) {
                for (int j = clone.length - 1; j >= i; j--) {
                    if (clone[j] < 0) {
                        long temp = clone[i];
                        clone[i] = clone[j];
                        clone[j] = temp;
                        break;
                    }
                }
            }
        }
        return clone;
    }
}
