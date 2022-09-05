package com.example.codewars3.codewars;//https://www.codewars.com/kata/5a24e2258f27f2bcb50000c7/train/java

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SurrealCheck {

    public static void main(String[] args) {
        System.out.println(isSurreal("18 33 -2 19 -1/8", "99 34 200/3"));
    }

    public static boolean isSurreal(String l, String r) {
        if (l == null || r == null) return true;
        if (l.isEmpty() || r.isEmpty()) return true;
        List<Double> left = new ArrayList<>();
        createDoublesList(l, left);
        Collections.sort(left);

        List<Double> right = new ArrayList<>();
        createDoublesList(r, right);
        Collections.sort(right);

        return left.get(left.size() - 1) < right.get(0);
    }

    private static void createDoublesList(String l, List<Double> doubles) {
        Arrays.asList(l.split(" ")).forEach(element -> {
            if (element.contains("/")) {
                Double first = Double.parseDouble(element.substring(0, element.indexOf("/")));
                Double secnd = Double.parseDouble(element.substring(element.indexOf("/") + 1));
                doubles.add(first / secnd);
            } else {
                doubles.add(Double.valueOf(element));
            }
        });
    }
}