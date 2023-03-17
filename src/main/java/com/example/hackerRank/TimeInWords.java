package com.example.hackerRank;
//https://www.hackerrank.com/challenges/the-time-in-words/problem

import java.util.HashMap;
import java.util.Map;

public class TimeInWords {

    public static void main(String[] args) {
        System.out.println(timeInWords(5, 35));
    }

    static String timeInWords(int h, int m) {

        StringBuilder time = new StringBuilder();
        Map<Integer, String> dictionary = new HashMap<>();
        dictionary.put(1, "one");
        dictionary.put(2, "two");
        dictionary.put(3, "three");
        dictionary.put(4, "four");
        dictionary.put(5, "five");
        dictionary.put(6, "six");
        dictionary.put(7, "seven");
        dictionary.put(8, "eight");
        dictionary.put(9, "nine");
        dictionary.put(10, "ten");
        dictionary.put(11, "eleven");
        dictionary.put(12, "twelve");
        dictionary.put(13, "thirteen");
        dictionary.put(14, "fourteen");
        dictionary.put(15, "quarter");
        dictionary.put(16, "sixteen");
        dictionary.put(17, "seventeen");
        dictionary.put(18, "eighteen");
        dictionary.put(19, "nineteen");
        dictionary.put(20, "twenty");
        dictionary.put(30, "half");

        if (m == 0) return dictionary.get(h) + " o' clock";

        time.append(convertMinutes(m, dictionary));
        time.append(convertHours(h, dictionary, m));
        return time.toString();
    }

    private static String convertMinutes(int m, Map<Integer, String> dictionary) {
        if (m == 0) return " o' clock";
        if (m == 1) return dictionary.get(m) + " minute past ";
        if (m == 15) return dictionary.get(m) + " past ";
        if (m > 1 && m < 20) return dictionary.get(m) + " minutes past ";
        if (m > 20 && m < 30) return "twenty " + dictionary.get(m - 20) + " minutes past ";
        if (m == 30) return dictionary.get(m) + " past ";
        if (m > 30) {
            int mOver30 = 60 - m;
            if (mOver30 == 1) return dictionary.get(mOver30) + " minute to ";
            if (mOver30 == 15) return dictionary.get(mOver30) + " to ";
            if (mOver30 < 20) return dictionary.get(mOver30) + " minutes to ";
            if (mOver30 > 20) return "twenty " + dictionary.get(mOver30 - 20) + " minutes to ";
        }
        return null;
    }

    private static String convertHours(int h, Map<Integer, String> dictionary, int m) {
        if (m > 30) return dictionary.get(h + 1);
        return dictionary.get(h);
    }

}
