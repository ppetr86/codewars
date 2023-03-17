package com.example.hackerRank;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CountTripletsV2 {

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

            return nrOfCombinations(map.get(keys.get(0)), map.get(keys.get(0)), map.get(keys.get(0)));

        }

        // iterate the distinct  keys
        for (int i = 0; i < keys.size() - 2; i++) {
            // if key is 1, r, r*r
            if (keys.get(i) == 1 && keys.get(i + 1) == r && keys.get(i + 2) == r * r) {
                long temp = nrOfCombinations(map.get(keys.get(i)), map.get(keys.get(i + 1)), map.get(keys.get(i + 2)));
                result += temp;
                continue;
            }

            long first = arr.get(i);
            if (first % r == 0 && keys.get(i + 1) == first * r && keys.get(i + 2) == first * r * r) {
                long temp = nrOfCombinations(map.get(keys.get(i)), map.get(keys.get(i + 1)), map.get(keys.get(i + 2)));
                result += temp;
            }
        }

        return result;
    }

    private static long nrOfCombinations(Long aLong, Long aLong1, Long aLong2) {
        long first = (aLong * aLong - 1) / 2;
        long sec = (aLong1 * aLong1 - 1) / 2;
        long third = (aLong2 * aLong2 - 1) / 2;
        return first + sec + third;
    }
}

//   get number of combinations
//    for (String each : map1.keySet()) {
//      int count = map1.get(each);
//      result += count * (count - 1) / 2;
//    }