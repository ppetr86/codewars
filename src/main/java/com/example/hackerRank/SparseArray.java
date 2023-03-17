package com.example.hackerRank;


//https://www.hackerrank.com/challenges/sparse-arrays/problem


import java.util.List;
import java.util.stream.Collectors;

public class SparseArray {

    public static void main(String[] args) {
        System.out.println(matchingStrings(List.of("def", "de", "fgh"), List.of("de", "lmn", "fgh")));
    }

    public static List<Integer> matchingStrings(List<String> strings, List<String> queries) {
        return queries.stream().map(query -> strings.stream()
                        .filter(string -> string.equals(query))
                        .count())
                .map(Math::toIntExact)
                .collect(Collectors.toList());
    }
}
