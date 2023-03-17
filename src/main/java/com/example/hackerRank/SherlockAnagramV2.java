package com.example.hackerRank;
//https://www.hackerrank.com/challenges/sherlock-and-anagrams/problem
//timeout on this approach

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class SherlockAnagramV2 {
    public static void main(String[] args) {
        System.out.println(sherlockAndAnagrams("ifailuhkqq"));
    }

    private static int sherlockAndAnagrams(String str) {
        int result = 0;

        // first loop for string length
        for (int strLen = 1; strLen <= str.length() / 2 + 1; strLen++) {

            for (int i = 0; i < str.length() - strLen; i++) {
                String leftStr = str.substring(i, i + strLen);
                Map<String, Long> map1 = createMap(leftStr);
                for (int j = i + 1; j < str.length() - strLen + 1; j++) {
                    String rightStr = str.substring(j, j + strLen);
                    if (leftStr.length() == rightStr.length() && leftStr.contains(rightStr.substring(0, 1))) {
                        Map<String, Long> map2 = createMap(rightStr);
                        if (map1.equals(map2)) result++;
                    }
                }
            }
        }
        return result;
    }

    private static Map<String, Long> createMap(String leftStr) {
        return Arrays.stream(leftStr.split(""))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    }
}
