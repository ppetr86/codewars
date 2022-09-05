package com.example.codewars3.codewars.kyu6;
//https://www.codewars.com/kata/5226eb40316b56c8d500030f/solutions/java

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PascalsTriangle {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(generate(12)));
        System.out.println("----");
        System.out.println(Arrays.toString(generateV2(12)));
    }

    public static long[] generateV2(int level) {
        int resultLen = arrLen(level);
        long[] result = new long[resultLen];
        int innerIndex = -1;
        int levelCounter = 1;

        for (int i = 0; i < resultLen; i++) {
            innerIndex++;
            if (innerIndex == 0) {
                result[i] = 1;
                if (i == 0) {
                    innerIndex = -1;
                    levelCounter++;
                }
            } else if (innerIndex < levelCounter - 1) {
                result[i] = result[i - levelCounter] + result[i - levelCounter + 1];
            } else if (innerIndex == levelCounter - 1) {
                result[i] = 1;
                innerIndex = -1;
                levelCounter++;
            }
        }
        return result;
    }

    private static int arrLen(int level) {
        if (level == 1) return 1;
        return level + arrLen(level - 1);
    }

    public static long[] generate(int level) {
        List<List<Long>> outer = new ArrayList<>(level);
        long[] result = new long[arrLen(level)];
        int index = 0;
        for (int i = 1; i <= level; i++) {
            List<Long> inner = new ArrayList<>(i);
            for (int j = 0; j < i; j++) {
                if (j == 0 || j == i - 1) {
                    inner.add(1L);
                    result[index++] = 1;
                } else {
                    long left = outer.get(outer.size() - 1).get(j - 1);
                    long right = +outer.get(outer.size() - 1).get(j);
                    inner.add(left + right);
                    result[index++] = left + right;
                }
            }
            outer.add(inner);
        }
        return result;
        //return outer.stream().flatMap(List::stream).mapToLong(Long::longValue).toArray();
    }


}
