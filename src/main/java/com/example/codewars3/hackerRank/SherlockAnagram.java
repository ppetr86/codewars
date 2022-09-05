package com.example.codewars3.hackerRank;
//https://www.hackerrank.com/challenges/sherlock-and-anagrams/problem
//timeout on this approach

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class SherlockAnagram {
    public static void main(String[] args) {
        System.out.println(sherlockAndAnagrams("abba"));
    }

    private static int sherlockAndAnagrams(String str) {
        int result = 0;

        // všechny možné délky, které zkoumám
        for (int strLen = 1; strLen <= str.length() / 2 + 1; strLen++) {

            //substring1
            for (int i = 0; i < str.length() - strLen; i++) {
                List<String> leftList = Arrays.asList(str.substring(i, i + strLen).split("")).stream().sorted().collect(Collectors.toList());

                //substring2
                for (int j = i + 1; j < str.length() - strLen + 1; j++) {
                    List<String> rightList = Arrays.asList(str.substring(j, j + strLen).split("")).stream().sorted().collect(Collectors.toList());
                    if (leftList.equals(rightList)) result++;
                }
            }
        }
        return result;
    }
}
