package com.example.companyTest.prefixbox;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Test {

    public static void main(String[] args) {
        String[] fruitBasket = new String[]{"zulu", "apple", "banana", "coconut", "durian",
                "banana", "elderberry", "fig", "grapefruit"};

        System.out.println(Arrays.toString(fruitBasket));
        Arrays.sort(fruitBasket);
        System.out.println(Arrays.toString(fruitBasket));

        System.out.println(findTheDuplicate(fruitBasket));
        countTheWords("Boci, boci tarka, se füle, se farka. boCi!");

        System.out.println(isPalindrom("hello"));
        System.out.println(isPalindromV2("rotor"));
    }

    private static String findTheDuplicate(String[] fruitBasket) {
        Arrays.sort(fruitBasket);

        for (int i = 0; i < fruitBasket.length - 1; i++) {
            if (fruitBasket[i].equals(fruitBasket[i + 1])) return fruitBasket[i];
        }
        return "";
    }


    private static boolean isPalindrom(String str) {
        StringBuilder sb = new StringBuilder(str);
        sb.reverse();
        return str.equals(sb.toString());
    }

    private static boolean isPalindromV2(String str) {
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) != str.charAt(str.length() - 1 - i)) return false;
        }
        return true;
    }

    public static void countTheWords(String crazyLongString) {
        Map<String, Integer> wordFrequencies = new HashMap<>();
        String[] strArr = crazyLongString.split(" ");

        for (String s : strArr) {
            String current = s.toLowerCase().replaceAll("[.,!?]", "");
            wordFrequencies.putIfAbsent(current, 0);
            wordFrequencies.put(current, wordFrequencies.get(current) + 1);
        }

        for (Map.Entry each : wordFrequencies.entrySet()) {
            System.out.println(each.getKey() + ":" + each.getValue());
        }
    }
}