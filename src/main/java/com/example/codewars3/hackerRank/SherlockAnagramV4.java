package com.example.codewars3.hackerRank;
//https://www.hackerrank.com/challenges/sherlock-and-anagrams/problem
// working approach

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class SherlockAnagramV4 {
    public static void main(String[] args) {
        System.out.println(sherlockAndAnagrams("ifailuhkqq"));
    }

    private static int sherlockAndAnagrams(String str) {
        int result = 0;
        Map<String, Integer> map1 = new HashMap<>();

        for (int i = 0; i < str.length(); i++) {
            for (int j = i; j < str.length(); j++) {
                char[] charArr = str.substring(i, j + 1).toCharArray();
                Arrays.sort(charArr);
                String subStr = new String(charArr);
                if (map1.containsKey(subStr)) {
                    map1.put(subStr, map1.get(subStr) + 1);
                } else {
                    map1.put(subStr, 1);
                }
            }
        }
        // get number of combinations
        for (String each : map1.keySet()) {
            int count = map1.get(each);
            result += count * (count - 1) / 2;
        }
        return result;
    }
}