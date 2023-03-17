package com.example.hackerRank;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Anagrams {

    public static void main(String[] args) {
        System.out.println(makeAnagram("fcrxzwscanmligyxyvym", "jxwtrhvujlmrpdoqbisbwhmgpmeoke"));
    }

    static int makeAnagram(String a, String b) {

        // the line below is not good for efficiency
        //if (a.chars().sorted().toString().equals(b.chars().sorted().toString())) return 0;

        HashMap<String, Integer> aMap = new HashMap<>();
        HashMap<String, Integer> bMap = new HashMap<>();

        Arrays.stream(a.split(""))
                .forEach(each -> {
                    if (aMap.containsKey(each)) aMap.put(each, aMap.get(each) + 1);
                    else aMap.put(each, 1);
                });

        Arrays.stream(b.split(""))
                .forEach(each -> {
                    if (bMap.containsKey(each)) bMap.put(each, bMap.get(each) + 1);
                    else bMap.put(each, 1);
                });

        StringBuilder anagram = new StringBuilder();

        for (Map.Entry<String, Integer> eachPair : aMap.entrySet()) {
            if (bMap.containsKey(eachPair.getKey())) {

                int keyCountA = eachPair.getValue();
                int keyCountB = bMap.get(eachPair.getKey());

                for (int i = 0; i < Math.min(keyCountA, keyCountB); i++) {
                    anagram.append(eachPair.getKey());
                }
            }
        }

        return a.length() + b.length() - (2 * anagram.length());
    }
}
