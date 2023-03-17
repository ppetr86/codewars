package com.example.codewars.kyu5;

import java.util.Arrays;
import java.util.stream.Collectors;

//https://www.codewars.com/kata/520b9d2ad5c005041100000f/train/java
//https://www.codewars.com/kata/520b9d2ad5c005041100000f/solutions/java

public class SimplePigLatin {

    public static void main(String[] args) {
        System.out.println(pigIt("Pig latin is cool"));
        System.out.println(pigItV2("This is my string"));
        String test = "a";
        System.out.println(test.substring(1));
    }

    public static String pigItV2(String str) {

        return Arrays.stream(str.split(" ")).map(SimplePigLatin::handle).collect(Collectors.joining(" "));
    }

    public static String handle(String each) {
        if (each.matches("[.!?]"))
            return each;
        return each.substring(1) + each.charAt(0) + "ay";
    }

    public static String pigIt(String str) {
        String[] strArr = str.split(" ");
        StringBuilder result = new StringBuilder();

        for (String each : strArr) {
            if (each.length() == 1) {
                result.append(each);
                if (!each.matches("[.!?]")) {
                    result.append("ay ");
                }
                continue;
            }
            result.append(each.substring(1)).append(each.charAt(0)).append("ay ");
        }
        return result.toString().trim();
    }
}
