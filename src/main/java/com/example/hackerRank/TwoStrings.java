package com.example.hackerRank;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class TwoStrings {

    public static void main(String[] args) {
        System.out.println(twoStringsMethod("wouldyoulikefries", "abcabcabcabcabcabc"));
    }

  /*private static String twoStringsMethod(String str1, String str2) {
    for (int i = 0; i < str1.length(); i++) {
      if (str2.contains(str1.substring(i,i+1))) return "YES";
    }
    return "NO";
  }*/

    private static String twoStringsMethod(String str1, String str2) {
        Set<String> first = new HashSet<>(Arrays.asList(str1.split("")));
        Set<String> second = new HashSet<>(Arrays.asList(str2.split("")));

        first.retainAll(second);
        return first.size() > 0 ? "YES" : "NO";
    }
}
