package com.example.codewars3;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Merge2MapsTest {

    public static void main(String[] args) {
        Map<String, Set<String>> mergeIntoMap = new HashMap<>();
        Map<String, Set<String>> mergeFromMap = new HashMap<>();

        Set<String> s3 = new HashSet<>();
        s3.add("18d706bb-6c08-4244-a93b-7f3925dca252");
        mergeFromMap.put("0bf87a45-55b5-4fb8-88d1-415ea3cb0417", s3);

        Set<String> s1 = new HashSet<>();
        s1.add("17637ab6-fca6-4290-9491-1d5ad04023fa");
        s1.add("18d706bb-6c08-4244-a93b-7f3925dca252");
        mergeIntoMap.put("0bf87a45-55b5-4fb8-88d1-415ea3cb0417", s1);

        Set<String> s2 = new HashSet<>();
        s2.add("1c69480d-1984-427b-adf4-ff2a72af8681");
        mergeFromMap.put("3a75e0c9-f7a1-455a-a06b-93630bd989a9", s2);

        Set<String> s4 = new HashSet<>();
        s4.add("f3081ea3-dfe9-4d63-b870-df557e6f32b6");
        s4.add("18d706bb-6c08-4244-a93b-7f3925dca252");
        mergeFromMap.put("949e5bd0-8c1f-4b9b-84e5-8df55b57d0b6", s4);

        var result = mergeMaps(mergeFromMap, mergeIntoMap);

        System.out.println(result.size());
    }

    private static Map<String, Set<String>> mergeMaps(Map<String, Set<String>> first, Map<String, Set<String>> second) {
        second.forEach((k, v) -> first.merge(k, v, (prev, cur) -> {
            prev.addAll(cur);
            return prev;
        }));
        return first;
    }
}
