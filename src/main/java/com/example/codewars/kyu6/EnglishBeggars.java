package com.example.codewars.kyu6;

import java.util.Arrays;
import java.util.LinkedList;

public class EnglishBeggars {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(beggars(new int[]{9, 654, 4, 10, 3, 281, 10, 56, 699,
                81, 663, 74, 84, 119, 3, 9, 75, 1, 66, 894, 1, 61, 76, 6, 4, 574, 3}, 9)));
        System.out.println(Arrays.toString(beggarsV2(new int[]{9, 654, 4, 10, 3, 281, 10, 56, 699,
                81, 663, 74, 84, 119, 3, 9, 75, 1, 66, 894, 1, 61, 76, 6, 4, 574, 3}, 9)));
    }

    public static int[] beggarsV2(int[] values, int n) {
        if (n == 0) return new int[0];
        int[] result = new int[n];

        LinkedList<Integer> myQ = new LinkedList<>();
        for (int value : values) {
            myQ.add(value);
        }

        int beggar = 0;
        while (!myQ.isEmpty()) {
            int current = myQ.poll();
            result[beggar] += current;

            beggar++;
            if (beggar == n) beggar = 0;
        }

        return result;
    }

    public static int[] beggars(int[] values, int n) {
        if (n == 0) return new int[0];
        int[] result = new int[n];

        for (int i = 0; i < values.length; i++) {
            result[i % n] += values[i];
        }

        return result;
    }
}