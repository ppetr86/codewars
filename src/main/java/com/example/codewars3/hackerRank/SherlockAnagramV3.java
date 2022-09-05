package com.example.codewars3.hackerRank;
//https://www.hackerrank.com/challenges/sherlock-and-anagrams/problem
//timeout on this approach

import java.util.Arrays;

public class SherlockAnagramV3 {
    public static void main(String[] args) {
        System.out.println(sherlockAndAnagrams("ifailuhkqq"));
    }

    private static int sherlockAndAnagrams(String str) {
        int result = 0;

        for (int strLen = 1; strLen <= str.length() / 2 + 1; strLen++) {
            for (int i = 0; i < str.length() - strLen; i++) {
                String leftStr = str.substring(i, i + strLen);
                for (int j = i + 1; j < str.length() - strLen + 1; j++) {
                    String rightStr = str.substring(j, j + strLen);
                    if (leftStr.contains(rightStr.substring(0, 1))) {
                        char[] leftList = str.substring(i, i + strLen).toCharArray();
                        Arrays.sort(leftList);
                        char[] rightList = str.substring(j, j + strLen).toCharArray();
                        Arrays.sort(rightList);
                        if (Arrays.equals(rightList, leftList)) result++;
                    }
                }
            }
        }
        return result;
    }
}
