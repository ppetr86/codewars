package com.example.codewars3.hackerRank;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CountTriplets {

    public static void main(String[] args) {
        List<Long> input = Arrays.asList(1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L,
                1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L,
                1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L,
                1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L);
        List<Long> input2 = List.of(1L, 3L, 9L, 9L, 27L, 81L);
        System.out.println(countTriplets(input, 1));
    }

    static long countTriplets(List<Long> arr, long r) {

        // map with triplets and their indices
        Map<Long, Long> map = arr.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        List<Long> keys = arr.stream().distinct().collect(Collectors.toList());
        long result = 0L;

        if (keys.size() == 1 && r == 1) {
            for (int i = 0; i < arr.size() - 2; i++) {
                if (arr.get(i) == r && arr.get(i + 1) == r && arr.get(i + 2) == r) {
                    result++;
                }
            }
            return result;
        }

        for (int i = 0; i < keys.size() - 2; i++) {
            if (keys.get(i) == 1 && keys.get(i + 1) == r && keys.get(i + 2) == r * r) {
                long temp = map.get(keys.get(i)) * map.get(keys.get(i + 1)) * map.get(keys.get(i + 2));
                result += temp;
                continue;
            }

            long first = arr.get(i);
            if (first % r == 0 && keys.get(i + 1) == first * r && keys.get(i + 2) == first * r * r) {
                long temp = map.get(keys.get(i)) * map.get(keys.get(i + 1)) * map.get(keys.get(i + 2));
                result += temp;
            }
        }

        return result;
    }
}
