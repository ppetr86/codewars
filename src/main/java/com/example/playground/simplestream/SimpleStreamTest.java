package com.example.playground.simplestream;

import java.util.Arrays;
import java.util.Collection;

public class SimpleStreamTest {
    public static void main(String[] args) {
        Collection<String> c = Arrays.asList("a", "bb",
                "ccc", "dddd");
        new SimpleStream<String>(c.iterator())
                .filter(s -> s.length() > 1)
                .filter(s -> s.length() < 4)
                .map(String::toUpperCase)
                .forEach(System.out::println);
        Integer max = new SimpleStream<String>(c.iterator())
                .filter(s -> s.length() > 1)
                .filter(s -> s.length() < 4)
                .map(s -> s.length())
                .reduce(0, (i1, i2) -> Math.max(i1, i2));
        System.out.println("The max length is " + max);
    }
}
