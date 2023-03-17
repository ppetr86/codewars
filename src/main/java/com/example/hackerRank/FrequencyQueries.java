package com.example.hackerRank;
//https://www.hackerrank.com/challenges/frequency-queries/copy-from/207957149
//works

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class FrequencyQueries {
    public static void main(String[] args) {
        List<int[]> input = new ArrayList<>();
        input.add(new int[]{3, 4});
        input.add(new int[]{2, 1003});
        input.add(new int[]{1, 16});
        input.add(new int[]{3, 1});
    /*input.add(new int[]{1, 3});
    input.add(new int[]{2, 3});
    input.add(new int[]{3, 2});
    input.add(new int[]{1, 4});
    input.add(new int[]{1, 5});
    input.add(new int[]{1, 5});
    input.add(new int[]{1, 4});
    input.add(new int[]{3, 2});
    input.add(new int[]{2, 4});
    input.add(new int[]{3, 2});*/

        System.out.println(freqQuery(input));
    }

    static List<Integer> freqQuery(List<int[]> queries) {
        List<Integer> result = new ArrayList<>();
        Map<Integer, Integer> valToFreq = new HashMap<>();
        Map<Integer, Set<Integer>> freqToVal = new HashMap<>();

        for (int[] query : queries) {
            if (query[0] == 1) {
                insert(query[1], valToFreq, freqToVal);
                continue;
            }
            if (query[0] == 2) {
                delete(query[1], valToFreq, freqToVal);
                continue;
            }
            if (query[0] == 3) {
                checkIfPresentWithFrequency(query[1], valToFreq, result, freqToVal);
            }
        }
        return result;
    }

    private static void checkIfPresentWithFrequency(Integer integer, Map<Integer, Integer> map, List<Integer> result, Map<Integer, Set<Integer>> freqToVal) {
        if (freqToVal.containsKey(integer)) {
            System.out.println(1);
            result.add(1);
            return;
        }
        result.add(0);
        System.out.println(0);
    }

    private static void delete(Integer number, Map<Integer, Integer> map, Map<Integer, Set<Integer>> freqToVal) {
        int frequencyOld = map.getOrDefault(number, 0);
        if (frequencyOld == 0) return;
        //remove element from frequency Value set
        freqToVal.get(frequencyOld).remove(number);

        // remove old frequency KV if set size 0
        if (freqToVal.get(frequencyOld).size() == 0) {
            freqToVal.remove(frequencyOld);
        }

        if (map.containsKey(number) && map.get(number) == 1) {
            map.remove(number);
        }

        // vlozit do noveho setu
        if (map.containsKey(number) && map.get(number) > 1) {
            map.replace(number, map.get(number) - 1);
            //frequency is > 1,
            // remove
            freqToVal.putIfAbsent(frequencyOld - 1, new HashSet<>());
            freqToVal.get(frequencyOld - 1).add(number);
            return;
        }
    }

    private static void insert(Integer number, Map<Integer, Integer> map, Map<Integer, Set<Integer>> freqToVal) {
        int frequencyOld = map.getOrDefault(number, 0);
        map.put(number, frequencyOld + 1);
        freqToVal.putIfAbsent(frequencyOld + 1, new HashSet<>());
        freqToVal.get(frequencyOld + 1).add(number);

        if (frequencyOld > 0 && freqToVal.containsKey(frequencyOld)) {
            freqToVal.get(frequencyOld).remove(number);

            if (freqToVal.get(frequencyOld).size() == 0) {
                freqToVal.remove(frequencyOld);
            }
        }

    }
}