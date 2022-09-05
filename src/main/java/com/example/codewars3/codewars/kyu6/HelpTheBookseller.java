package com.example.codewars3.codewars.kyu6;

import java.util.Arrays;
import java.util.Map;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.summingInt;

public class HelpTheBookseller {

    public static void main(String[] args) {

        String lstOfArt[] = new String[]{"ABAR 200", "CDXE 500", "BKWR 250", "BTSQ 890", "DRTY 600"};
        String lstOf1stLetter[] = new String[]{"A", "B", "W"};

        System.out.println(stockSummary(lstOfArt, lstOf1stLetter));

    }

    public static String stockSummary(String[] lstOfArt, String[] lstOf1stLetter) {

        if (lstOfArt.length == 0 || lstOf1stLetter.length == 0)
            return "";

        Map<String, Integer> map = Arrays.stream(lstOfArt).collect(groupingBy(str -> str.substring(0, 1), summingInt(HelpTheBookseller::getNumber)));

        String result = "";

        result = Arrays.stream(lstOf1stLetter)
                .map(letter -> "(" + letter + " : " + map.getOrDefault(letter, 0) + ") - ")
                .collect(joining());

        return result.substring(0, result.length() - 3);
    }

    public static int getNumber(String str) {
        return Integer.parseInt(str.substring(str.indexOf(" ") + 1));
    }
}
