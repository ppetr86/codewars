package com.example.codewars3.codewars;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class AreSame {

    public static void main(String[] args) {
        System.out.println(comp(new int[]{4, 2, 6, 8, 9},
                new int[]{81, 4, 36, 64, 16}));
    }

    public static boolean comp(int[] a, int[] b) {

        if (a == null || b == null) return false;
        if (a.length == 0 && b.length == 0) return false;
        if (a.length != b.length) return false;

        List<Integer> alist = Arrays.stream(a).boxed().collect(Collectors.toList())
                .stream()
                .map(Math::abs)
                .map(x -> x * x)
                .sorted()
                .collect(Collectors.toList());

        return alist.equals(Arrays.stream(b).boxed().sorted().collect(Collectors.toList()));
    }
}