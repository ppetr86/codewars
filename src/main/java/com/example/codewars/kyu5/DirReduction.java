package com.example.codewars.kyu5;
//https://www.codewars.com/kata/550f22f4d758534c1100025a/train/java

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class DirReduction {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(dirReduc(new String[]{"SOUTH", "NORTH", "SOUTH", "EAST", "WEST", "NORTH", "WEST"})));
        System.out.println(Arrays.toString(dirReducV2(new String[]{"SOUTH", "NORTH", "SOUTH", "EAST", "WEST", "NORTH", "WEST"})));
        System.out.println("----------------");
        System.out.println(Arrays.toString(dirReducV3(new String[]{})));
        System.out.println(Arrays.toString(dirReducV4(new String[]{"SOUTH", "NORTH", "SOUTH", "EAST", "WEST", "NORTH", "WEST"})));
    }

    private static String[] dirReducV4(String[] strings) {

        LinkedList<String> linkedStrings = new LinkedList<>(Arrays.asList(strings));

        for (int i = 0; i < linkedStrings.size() - 1; i++) {
            if ((linkedStrings.get(i).equals("NORTH") && linkedStrings.get(i + 1).equals("SOUTH")) ||
                    (linkedStrings.get(i).equals("SOUTH") && linkedStrings.get(i + 1).equals("NORTH")) ||
                    (linkedStrings.get(i).equals("EAST") && linkedStrings.get(i + 1).equals("WEST")) ||
                    (linkedStrings.get(i).equals("WEST") && linkedStrings.get(i + 1).equals("EAST"))) {
                linkedStrings.remove(i + 1);
                linkedStrings.remove(i);
                i = -1;
            }
        }

        return linkedStrings.toArray(String[]::new);

    }

    // looks good, but is not a valid approach, since only neighbours can be reduced
    public static String[] dirReducV3(String[] strings) {
        String string = String.join(" ", strings);

        string = replacePairs(string, "SOUTH", "NORTH");
        string = replacePairs(string, "EAST", "WEST");

        string = string.trim().replaceAll(" +", " ");

        return string.length() == 0 ? new String[]{} : string.split(" ");

    }

    public static String replacePairs(String string, String dir1, String dir2) {
        if (!string.contains(dir1) || !string.contains(dir2))
            return string;
        string = string.replaceFirst(dir1, "").replaceFirst(dir2, "");
        return replacePairs(string, dir1, dir2);
    }

    //doesnt pass
    public static String[] dirReducV2(String[] strings) {
        Map<String, Long> wordCounts = Arrays.stream(strings).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        removePairsFromMap(wordCounts, "SOUTH", "NORTH");
        removePairsFromMap(wordCounts, "EAST", "WEST");

        StringBuilder result = new StringBuilder();

        for (Map.Entry each : wordCounts.entrySet()) {
            if ((long) each.getValue() > 0L) result.append(each.getKey()).append(" ");
        }

        System.out.println(wordCounts);
        return result.toString().split(" ");

    }

    public static void removePairsFromMap(Map<String, Long> wordCounts, String dir1, String dir2) {

        long maxKey = Math.max(wordCounts.getOrDefault(dir1, 0L), wordCounts.getOrDefault(dir2, 0L));
        long minKey = Math.min(wordCounts.getOrDefault(dir1, 0L), wordCounts.getOrDefault(dir2, 0L));

        if (maxKey == 0 || minKey == 0) return;
        if (wordCounts.get(dir1) == maxKey) {
            wordCounts.put(dir1, maxKey - minKey);
            wordCounts.remove(dir2);
            return;
        }
        wordCounts.put(dir2, maxKey - minKey);
        wordCounts.remove(dir1);
    }

    public static String[] dirReduc(String[] arr) {

        List<String> result = Arrays.stream(arr).collect(Collectors.toList());

        for (int i = 0; i < result.size() - 1; i++) {
            if ((result.get(i).equals("NORTH") && result.get(i + 1).equals("SOUTH")) ||
                    (result.get(i).equals("SOUTH") && result.get(i + 1).equals("NORTH")) ||
                    (result.get(i).equals("EAST") && result.get(i + 1).equals("WEST")) ||
                    (result.get(i).equals("WEST") && result.get(i + 1).equals("EAST"))) {
                result.remove(i + 1);
                result.remove(i);
                i = -1;
            }
        }

        return result.toArray(String[]::new);
    }
}