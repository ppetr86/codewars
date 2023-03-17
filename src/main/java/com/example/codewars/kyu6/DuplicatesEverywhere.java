package com.example.codewars.kyu6;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

//https://www.codewars.com/kata/5e8dd197c122f6001a8637ca/train/java
//
public class DuplicatesEverywhere {

    public static void main(String[] args) {
        Map<Integer, List<String>> inputMap = new HashMap<>();
        inputMap.put(432, Arrays.asList("A", "A", "B", "main.java.D"));
        inputMap.put(53, Arrays.asList("L", "G", "B", "main.java.C"));
        inputMap.put(236, Arrays.asList("L", "A", "X", "G", "H", "X"));
        inputMap.put(11, Arrays.asList("P", "R", "S", "main.java.D"));

        System.out.println(removeDuplicateIds(inputMap));
    }

    public static Map<Integer, List<String>> removeDuplicateIds(Map<Integer, List<String>> obj) {

        int[] sortedKeys = obj.keySet().stream().sorted(Comparator.reverseOrder()).mapToInt(i -> i).toArray();

        Set<String> used = new HashSet<>();

        for (int i = 0; i < sortedKeys.length; i++) {
            List<String> iValues = obj.get(sortedKeys[i]).stream().distinct().collect(Collectors.toList());
            if (i > 0)
                iValues.removeAll(used);
            used.addAll(iValues);

            obj.put(sortedKeys[i], iValues);
        }

        return obj;
    }

}
