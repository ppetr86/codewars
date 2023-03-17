package com.example.codewars;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//https://www.codewars.com/kata/59f7597716049833200001eb/train/java
public class UpsideDown {

    public static void main(String[] args) {
        System.out.println(solve(10, 100));
    }

    public static int solve(int x, int y) {
        int result = 0;

        Map<Integer, Integer> rotateMap = new HashMap<>();
        rotateMap.put(0, 0);
        rotateMap.put(1, 1);
        rotateMap.put(8, 8);
        rotateMap.put(6, 9);
        rotateMap.put(9, 6);
        List<Integer> rotateInts = new ArrayList<>(rotateMap.keySet());

        for (int i = x; i <= y; i++) {
            char[] chars = String.valueOf(i).toCharArray();

        }

        return result;
    }
}