package com.example.codewars3.hackerRank;

import java.util.HashMap;

public class SalesByMatch {
    public static void main(String[] args) {
        System.out.println(pairs(new int[]{10, 20, 20, 10, 10, 30, 50, 10, 20}));
    }

    private static int pairs(int[] ints) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int each : ints) {
            if (map.containsKey(each)) map.put(each, map.get(each) + 1);
            else map.put(each, 1);
        }
        return map.values().stream().filter(x -> x > 1).map(x -> x / 2).reduce(0, Integer::sum);
    }
}
