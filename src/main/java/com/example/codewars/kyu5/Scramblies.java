package com.example.codewars.kyu5;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Scramblies {
    public static void main(String[] args) {
        System.out.println(scramble("rkqodlw", "world"));
    }

    public static boolean scramble(String str1, String str2) {

        if (str1.length() < str2.length()) return false;

        Map<String, Long> map1 = Arrays.stream(str1.split("")).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        Map<String, Long> map2 = Arrays.stream(str2.split("")).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println(map1);
        System.out.println(map2);

        for (Map.Entry<String, Long> each : map2.entrySet()) {
            // iterate map 2
            // if map1 doesnt contain the key of map1 --> false
            if (!map1.containsKey(each.getKey())) return false;
            // map1 contains key of map2.... value of map2key is bigger than
            if (map1.containsKey(each.getKey()) && each.getValue() > map1.get(each.getKey())) return false;
        }

        return true;
    }
}
