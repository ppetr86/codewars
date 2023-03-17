package com.example.hackerRank;

import java.util.ArrayList;
import java.util.List;

public class RotateLeft {

    public static void main(String[] args) {
        System.out.println(rotateLeft(1, List.of(1, 2, 3, 4, 5)));
    }

    public static List<Integer> rotateLeft(int d, List<Integer> arr) {
        List<Integer> result = new ArrayList<>(arr.size());

        for (int i = 0; i < arr.size(); i++) {
            int newIndex = (i + d) % arr.size();
            result.add(arr.get(newIndex));
        }

        return result;
    }
}
