package com.example.hackerRank;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

//https://www.hackerrank.com/challenges/migratory-birds/problem
public class MigratoryBirds {

    public static void main(String[] args) {
        System.out.println(migratoryBirds(List.of(1, 2, 3, 4, 5, 4, 3, 2, 1, 3, 4)));
        System.out.println(migratoryBirdsMap(List.of(1, 2, 3, 4, 5, 4, 3, 2, 1, 3, 4)));
    }

    static int migratoryBirdsMap(List<Integer> arr) {
        Map<Integer, Integer> frequencyMap = new HashMap<>();

        for (Integer each : arr) {
            frequencyMap.putIfAbsent(each, 0);
            frequencyMap.put(each, frequencyMap.get(each) + 1);
        }
        int result = -1;
        int maxFrequency = frequencyMap.values().stream().max(Integer::compareTo).get();

        List<Integer> orderedKeys = frequencyMap.keySet().stream().sorted().collect(Collectors.toList());
        System.out.println(frequencyMap);
        System.out.println(orderedKeys);
        for (Integer each : orderedKeys) {
            if (each == maxFrequency) {
                result = each;
            }
        }
        return result;
    }

    static int migratoryBirds(List<Integer> arr) {
        int[] frequencies = new int[5];

        for (Integer each : arr) {
            frequencies[each - 1]++;
        }

        int result = 0;
        System.out.println(Arrays.toString(frequencies));
        int maxFreq = Arrays.stream(frequencies).max().orElse(0);

        for (int i = 0; i < frequencies.length; i++) {
            if (frequencies[i] == maxFreq) {
                result = i + 1;
                break;
            }
        }
        return result;
    }
}
