package com.example.codewars3.playground;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamConcat {
    public static void main(String[] args) {
        List<Integer> numbers1 = List.of(10, 11, 2);
        List<Integer> numbers2 = List.of(1, 3, 4, 5);
        List<Integer> numbers1And2 = Stream.concat(numbers1.stream(), numbers2.stream()).sorted().collect(Collectors.toList());
        System.out.println(numbers1And2);
    }
}
