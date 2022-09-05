package com.example.codewars3.codewars.kyu6;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

//https://www.codewars.com/kata/56b5afb4ed1f6d5fb0000991/train/java
//https://www.codewars.com/kata/56b5afb4ed1f6d5fb0000991/solutions/java
public class ReverseOrRotate {

    public static void main(String[] args) {
        System.out.println(revRot("733049910872815764", 5));
    }

    public static String revRot(String strng, int sz) {
        if (sz <= 0 || strng.isEmpty() || sz > strng.length()) return "";

        List<List<String>> chunks = new ArrayList<>();
        List<String> current = new ArrayList<>(sz);
        for (int i = 0; i < strng.length(); i++) {
            current.add(strng.substring(i, i + 1));
            if (current.size() == sz) {
                int sum = digitSum(String.join("", current));
                if (sum % 2 == 0)
                    Collections.reverse(current);
                else
                    Collections.rotate(current, -1);
                chunks.add(current);
                // why I get different results with current.clear();???
                //current.clear();
                current = new ArrayList<>();
            }
        }

        return chunks.stream().map(each -> String.join("", each)).collect(Collectors.joining());
    }

    private static int digitSum(String join) {
        if (join.length() == 0) return 0;
        return Integer.parseInt(join.substring(0, 1)) + digitSum(join.substring(1));
    }
}