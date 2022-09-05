package com.example.codewars3.playground;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.stream.Collectors;

public class Chunks {

    public static void main(String[] args) {
        int[] input1 = new int[]{1, 2, 3, 4};
        int[] input2 = new int[]{1, 2, 3, 4, 5};
        int[] input3 = new int[]{1, 2, 3, 4, 5, 6, 7, 8};

        List<List<Integer>> result1 = chunkMe(input1, 2);
        List<List<Integer>> result2 = chunkMe(input2, 2);
        List<List<Integer>> result3 = chunkMe(input3, 3);
        List<List<Integer>> result4 = chunkMev2(input3, 3);
        List<List<Integer>> result5 = chunkMev3(input3, 3);

        System.out.println("V1");
        System.out.println(result3);
        System.out.println("V2");
        System.out.println(result4);
        System.out.println("V3");
        System.out.println(result5);
    }

    private static List<List<Integer>> chunkMev3(int[] input, int len) {
        List<List<Integer>> result = new ArrayList<>();

        Queue<Integer> myQ = Arrays.stream(input).boxed().collect(Collectors.toCollection(LinkedList::new));
        List<Integer> current = new ArrayList<>();
        while (!myQ.isEmpty()) {
            current.add(myQ.poll());
            if (current.size() == len || myQ.isEmpty()) {
                result.add(current);
                current = new ArrayList<>();
            }
        }
        return result;
    }

    private static List<List<Integer>> chunkMev2(int[] input, int len) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> current = new ArrayList<>();

        for (int i = 0; i < input.length; i++) {
            current.add(input[i]);
            if (current.size() == len || i == input.length - 1) {
                result.add(current);
                current = new ArrayList<>();
            }
        }
        return result;
    }

    private static List<List<Integer>> chunkMe(int[] input, int len) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> current = new ArrayList<>();

        for (int i = 0; i < input.length; i++) {
            if (i == input.length - 1) {
                current.add(input[i]);
                result.add(current);
                break;
            }
            if ((i % len == 0 && i > 0)) {
                result.add(current);
                current = new ArrayList<>();
            }
            current.add(input[i]);
        }
        return result;
    }
}